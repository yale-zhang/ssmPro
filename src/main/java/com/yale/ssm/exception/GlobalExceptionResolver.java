package com.yale.ssm.exception;

import com.alibaba.fastjson.JSON;
import com.yale.ssm.dto.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handeler, Exception ex) {
        //返回json格式的错误信息
        try {
            PrintWriter writer = response.getWriter();
            BaseResult result = new BaseResult(false, ex.getMessage());
            writer.write(JSON.toJSONString(result));
            writer.flush();
        } catch (Exception e) {
            LOG.error("Exception:",e);
        }
        return null;
    }
}
