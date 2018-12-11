package com.example.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
	/**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> errorHandler(Exception ex) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code", 500);
        map.put("msg", ex.getMessage());
        return map;
    }

}
