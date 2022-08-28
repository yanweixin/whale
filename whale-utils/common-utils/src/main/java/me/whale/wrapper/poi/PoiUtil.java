package me.whale.wrapper.poi;

import me.whale.wrapper.poi.excel.ExcelColumn;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class PoiUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(PoiUtil.class);

    private PoiUtil() {
    }

    public static <T> boolean createExcel(Path path, String sheetName, List<T> dataList) {
        if (Objects.isNull(path) || CollectionUtils.isEmpty(dataList)) {
            LOGGER.warn("path is null or data collection is empty");
            return false;
        }
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path.toFile()))) {
            writeData(outputStream, path.endsWith("xlsx"), sheetName, dataList);
            return true;
        } catch (Exception e) {
            LOGGER.warn("create excel file error", e);
        }
        return false;
    }

    public static <T> void writeData(OutputStream outputStream, boolean isXlsx, String sheetName, List<T> dataList) {
        try {
            Workbook workbook = WorkbookFactory.create(isXlsx);
            writeData(workbook, sheetName, dataList);
            workbook.write(outputStream);
        } catch (Exception e) {
            LOGGER.warn("create excel file error", e);
        }
    }

    public static <T> void writeData(Workbook workbook, String sheetName, List<T> dataList) throws IllegalAccessException {
        if (CollectionUtils.isEmpty(dataList)) {
            return;
        }

        Class<?> clazz = dataList.get(0).getClass();
        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        List<Object> sheetHeaders = new ArrayList<>();
        List<CellStyle> cellStyles = new ArrayList<>();
        final Map<String, CellStyle> patternCellStyleMap = new HashMap<>(16);
        retrieveColumnAndStyles(workbook, fields, sheetHeaders, patternCellStyleMap, cellStyles);

        SpreadsheetVersion spreadsheetVersion = workbook.getSpreadsheetVersion();
        if (fields.size() > spreadsheetVersion.getMaxColumns() || dataList.size() > spreadsheetVersion.getMaxRows()) {
            throw new RuntimeException("exceeds excel limitation on max size of columns or rows");
        }

        Sheet sheet = workbook.createSheet(WorkbookUtil.createSafeSheetName(sheetName));
        createRow(sheet, 0, sheetHeaders, new ArrayList<>());
        for (int i = 0; i < dataList.size(); i++) {
            List<Object> values = new ArrayList<>();
            for (Field field : fields) {
                values.add(field.get(dataList.get(i)));
            }
            createRow(sheet, i + 1, values, cellStyles);
        }
    }

    private static void retrieveColumnAndStyles(Workbook workbook, List<Field> fields, List<Object> sheetHeaders,
                                                Map<String, CellStyle> patternCellStyleMap, List<CellStyle> cellStyles) {
        CreationHelper creationHelper = workbook.getCreationHelper();
        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);
            if (field.getName().startsWith("this$")) {
                fields.remove(field);
                continue;
            }
            field.setAccessible(true);
            if (field.isAnnotationPresent(ExcelColumn.class)) {
                ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
                sheetHeaders.add(excelColumn.headerName());
                String pattern = excelColumn.pattern();
                CellStyle cellStyle = patternCellStyleMap.getOrDefault(pattern, null);
                if (cellStyle == null && StringUtils.isNotBlank(pattern)) {
                    cellStyle = workbook.createCellStyle();
                    cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat(pattern));
                    patternCellStyleMap.put(pattern, cellStyle);
                }
                cellStyles.add(cellStyle);
            } else {
                sheetHeaders.add(field.getName());
                cellStyles.add(null);
            }
        }
    }

    private static void createRow(Sheet sheet, int rowNum, List<Object> values, List<CellStyle> cellStyles) {
        boolean setStyle = true;
        if (cellStyles.size() > 0 && cellStyles.size() != values.size()) {
            throw new RuntimeException("style size not match with data size");
        } else if (cellStyles.size() == 0) {
            setStyle = false;
        }
        Row row = sheet.createRow(rowNum);
        for (int i = 0; i < values.size(); i++) {
            Object value = values.get(i);
            CellStyle cellStyle = setStyle ? cellStyles.get(i) : null;
            if (value == null) {
                row.createCell(i, CellType.BLANK);
            } else if (value instanceof Number) {
                Cell cell = row.createCell(i, CellType.NUMERIC);
                cell.setCellValue(((Number) value).doubleValue());
                cell.setCellStyle(cellStyle);
            } else if (value instanceof Date) {
                Cell cell = row.createCell(i, CellType.BLANK);
                cell.setCellValue((Date) value);
                cell.setCellStyle(cellStyle);
            } else {
                Cell cell = row.createCell(i, CellType.STRING);
                cell.setCellValue(value.toString());
            }
        }
    }
}
