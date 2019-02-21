package com.swjtu.girl.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李天峒
 * @date 2019/2/21 11:15
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "SimpleCORSFilter")
public class SimpleCorsFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(SimpleCorsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("第一个我被用了");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("第二个我被用了");
        HttpServletResponse response = (HttpServletResponse) res;
        System.out.println(response);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("第三个我也被用了");

    }
}