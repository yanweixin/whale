package me.whale.wrapper.poi;

import me.whale.wrapper.poi.PoiUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

class PoiUtilTest {

    class A {
        private String b;
        private String d;

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }
    }

    @Test
    void createExcel() throws IOException, IllegalAccessException {
        A a = new A();
        a.b = "a";
        a.d = "c";
        PoiUtil.createExcel(Paths.get("build/end.xlsx"), "第一页", List.of(a));
    }
}