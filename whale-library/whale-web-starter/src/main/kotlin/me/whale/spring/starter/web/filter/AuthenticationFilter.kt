package me.whale.spring.starter.web.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import me.whale.log.TraceId

class AuthenticationFilter : WhaleGenericFilter() {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val httpServletRequest = request as HttpServletRequest
        val userPrincipal = httpServletRequest.userPrincipal
        val userName = userPrincipal.name
        log.info("${TraceId.next()} $userName")
    }
}