package com.demo.encode.controller;

import com.demo.encode.result.EncodeResult;
import com.demo.encode.result.EncodeStatusCode;
import com.demo.encode.result.FailEncodeResult;
import com.demo.encode.service.AesEncodeService;
import com.demo.encode.service.Base64EncodeService;
import com.demo.encode.service.Sha256EncodeService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping(value = "/encoder/v1")
public class EncodeController {
    @Autowired
    private Sha256EncodeService sha256EncodeService;

    @Autowired
    private AesEncodeService aesEncodeService;

    @Autowired
    private Base64EncodeService base64EncodeService;
    /**
     * 用sha256编码,返回EncodeResult的Json形式
     */
    @GetMapping("/sha256")
    public EncodeResult encodeBySha256(@RequestParam("content") String content){
        EncodeResult encodeResult = new EncodeResult();
        try {
            encodeResult.setEncodeResult(sha256EncodeService.encrypt(content));
            encodeResult.setStatusCode(EncodeStatusCode.Success.getValue());
        }catch (Exception e){
            //一旦出现错误,就返回表示错误的code和空字符串
           encodeResult = new FailEncodeResult();
        }finally {
            return encodeResult;
        }
    }


    @GetMapping("/aes")
    public EncodeResult encodeByAes(@RequestParam("content") String content){
        EncodeResult encodeResult = new EncodeResult();
        try {
            encodeResult.setEncodeResult(aesEncodeService.encrypt(content));
            encodeResult.setStatusCode(EncodeStatusCode.Success.getValue());
        }catch (Exception e){
            //一旦出现错误,就返回表示错误的code和空字符串
            encodeResult = new FailEncodeResult();
        }finally {
            return encodeResult;
        }
    }

    @GetMapping("/base64")
    public EncodeResult encodeByBase64(@RequestParam("content") String content){
        EncodeResult encodeResult = new EncodeResult();
        try {
            encodeResult.setEncodeResult(base64EncodeService.encrypt(content));
            encodeResult.setStatusCode(EncodeStatusCode.Success.getValue());
        }catch (Exception e){
            //一旦出现错误,就返回表示错误的code和空字符串
            encodeResult = new FailEncodeResult();
        }finally {
            return encodeResult;
        }
    }
}
