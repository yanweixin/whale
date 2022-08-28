package me.whale.wrapper.poi;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class PoiContextTest {


    @Test
    void testExtMap() throws IOException, InterruptedException {
        Set<FormulaEvaluator> formulaEvaluators = ConcurrentHashMap.newKeySet();
        Set<DataFormat> dataFormats = ConcurrentHashMap.newKeySet();
        Workbook workbook = WorkbookFactory.create(true);
        int cnt = Runtime.getRuntime().availableProcessors() * 100;
        ExecutorService executorService = Executors.newFixedThreadPool(cnt);
        CountDownLatch latch = new CountDownLatch(cnt);
        for (int i = 0; i < cnt; i++) {
            executorService.submit(() -> {
                formulaEvaluators.add(PoiContext.getFormulaEval(workbook));
                dataFormats.add(PoiContext.getDataFormat(workbook));
                latch.countDown();
            });
        }
        latch.await();
        assertEquals(1, formulaEvaluators.size());
        assertEquals(1, dataFormats.size());
    }
}