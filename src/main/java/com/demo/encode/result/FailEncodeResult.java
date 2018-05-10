package com.demo.encode.result;

public class FailEncodeResult extends EncodeResult {
    public FailEncodeResult() {
        this.setEncodeResult("");
        this.setStatusCode(EncodeStatusCode.Fail.getValue());
    }
}
