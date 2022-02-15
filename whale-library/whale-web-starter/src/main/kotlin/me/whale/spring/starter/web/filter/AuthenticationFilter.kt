package me.whale.spring.starter.web.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import org.springframework.web.filter.GenericFilterBean

class AuthenticationFilter : GenericFilterBean() {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        TODO("Not yet implemented")
    }
}