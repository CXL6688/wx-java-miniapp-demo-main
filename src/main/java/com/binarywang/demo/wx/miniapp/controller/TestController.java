package com.binarywang.demo.wx.miniapp.controller;


import com.binarywang.demo.wx.miniapp.base.vo.ResponseResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {
    @GetMapping("/test")
    public ResponseResult test() {
        return ResponseResult.SUCCESS();
    }

}
