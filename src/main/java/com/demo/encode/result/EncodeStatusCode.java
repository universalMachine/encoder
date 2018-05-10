package com.demo.encode.result;

public enum EncodeStatusCode {
    Success(200),
    Fail(577);
    private Integer value;

    EncodeStatusCode(Integer statucCode) {
        this.value = statucCode;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
