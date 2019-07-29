package com.weweibuy.webuy.eureka.filter;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author durenhao
 * @date 2019/7/29 23:45
 **/
@Slf4j
@Order(Integer.MIN_VALUE)
@Component
public class FilterForSentinelTest extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Entry entry = null;
        try {
            entry = SphU.entry("eureka-sentinel-test-resource");
            filterChain.doFilter(request, response);
        } catch (BlockException e1) {
            log.info("流控", e1);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }

    }
}
