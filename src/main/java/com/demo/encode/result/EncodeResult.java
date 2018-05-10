package com.demo.encode.result;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class EncodeResult {
    /**
     * 表示编码成功或失败
     */

    private Integer statusCode;
    /**
     * 编码的结果，如果编码失败则是空字符串
     */

    private String  encodeResult;

    public EncodeResult() {
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getEncodeResult() {
        return encodeResult;
    }

    public void setEncodeResult(String encodeResult) {
        this.encodeResult = encodeResult;
    }
}
