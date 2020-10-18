package com.paascloud.core.web.advice;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paascloud.core.web.api.R;
import com.paascloud.core.exception.BaseException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = "com.paascloud.provider.controller")
public class ResponseControllerAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !methodParameter.getGenericParameterType().equals(R.class) && !methodParameter.getGenericParameterType().equals(Void.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // String类型不能直接包装，所以要进行些特别的处理
        if (methodParameter.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在ResultVO里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(R.ok(o));
            } catch (JsonProcessingException e) {
                throw new BaseException("返回String类型错误");
            }
        }
        return R.ok(o);
    }
}
