package me.whale.spring.starter.web.filter;

import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serial;

/**
 * @author weixin
 */
public abstract class WhaleGenericFilter extends GenericFilter {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    @Serial
    private static final long serialVersionUID = -4526817057865711426L;

    @Override
    public void init() throws ServletException {
        log.info("initialize filter " + getFilterName());
    }

    @Override
    public void destroy() {
    }
}
