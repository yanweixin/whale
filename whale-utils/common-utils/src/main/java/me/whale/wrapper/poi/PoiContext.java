package me.whale.wrapper.poi;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Supplier;

public class PoiContext {
    private final static Map<Object, Map<String, Object>> CONTEXT_HOLDER = new WeakHashMap<>();

    private PoiContext() {
    }

    private static <T> T setExtMap(Object holder, String key, Supplier<T> supplier) {
        if (!CONTEXT_HOLDER.containsKey(holder)) {
            synchronized (CONTEXT_HOLDER) {
                if (!CONTEXT_HOLDER.containsKey(holder)) {
                    T value = supplier.get();
                    CONTEXT_HOLDER.put(holder, new HashMap<>() {{
                        put(key, value);
                    }});
                    return value;
                } else {
                    return setExtMap(holder, key, supplier);
                }
            }
        } else {
            synchronized (CONTEXT_HOLDER.get(holder)) {
                Map<String, Object> map = CONTEXT_HOLDER.get(holder);
                if (map.containsKey(key)) {
                    return (T) map.get(key);
                } else {
                    T value = supplier.get();
                    map.put(key, value);
                    return value;
                }
            }
        }
    }

    public static FormulaEvaluator getFormulaEval(Workbook workbook) {
        return setExtMap(workbook, "FORMULA_EVAL", () -> workbook.getCreationHelper().createFormulaEvaluator());
    }

    public static DataFormat getDataFormat(Workbook workbook) {
        return setExtMap(workbook, "DATA_FORMAT", () -> workbook.getCreationHelper().createDataFormat());
    }

    public static CellStyle getCellStyle(Workbook workbook, String styleKey) {
        return setExtMap(workbook, styleKey, workbook::createCellStyle);
    }
}
