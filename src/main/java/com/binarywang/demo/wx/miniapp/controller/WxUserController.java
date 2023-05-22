package com.binarywang.demo.wx.miniapp.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.binarywang.demo.wx.miniapp.base.vo.ResponseResult;
import com.binarywang.demo.wx.miniapp.entity.StoreWifi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class WxUserController {
    private final WxMaService maService;

    @GetMapping("/getUserOpenId")
    public ResponseResult getUserOpenId(String jsCode) throws WxErrorException {
        WxMaJscode2SessionResult sessionInfo = maService.getUserService().getSessionInfo(jsCode);
        return ResponseResult.SUCCESS(sessionInfo.getOpenid());
    }
}
