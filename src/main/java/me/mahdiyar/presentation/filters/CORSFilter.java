package me.mahdiyar.presentation.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
//        no implementation
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestOrigin = ((HttpServletRequest) servletRequest).getHeader("Origin");
        logger.info("request origin: " + requestOrigin);
        if (requestOrigin != null) {
            response.setHeader("Access-Control-Allow-Origin", requestOrigin);
        }
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "X-Requested-With, Content-Type, Origin, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Expose-Headers", "Content-Type, Origin, Accept, X-Requested-With, Authorization");
        filterChain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {
//        no implementation
    }
}