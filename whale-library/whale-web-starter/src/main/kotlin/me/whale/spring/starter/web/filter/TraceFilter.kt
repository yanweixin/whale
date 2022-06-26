package me.whale.spring.starter.web.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import me.whale.log.TraceId
import org.slf4j.MDC
import org.springframework.stereotype.Component


@Component
class TraceFilter : WhaleGenericFilter() {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        MDC.put("traceId", TraceId.next())
        try {
            chain?.doFilter(request, response)
        } finally {
            MDC.remove("traceId")
        }
    }

}