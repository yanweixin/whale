package me.whale.backend.controller

import me.whale.wrapper.PoiUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import jakarta.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/whale/web/backend/report")
class ReporterController {

    @GetMapping("/demo")
    fun demoReport(response: HttpServletResponse) {
        response.setContentType("application/octet-stream")
        response.setHeader("Content-Disposition", "attachment;fileName=" + "test.xlsx")
//        response.flushBuffer()
        PoiUtil.writeData(response.outputStream, true, "null", listOf("123"))
    }
}