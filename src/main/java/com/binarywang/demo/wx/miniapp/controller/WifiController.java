package com.binarywang.demo.wx.miniapp.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.binarywang.demo.wx.miniapp.base.vo.ResponseResult;
import com.binarywang.demo.wx.miniapp.entity.StoreWifi;
import com.binarywang.demo.wx.miniapp.mapper.StoreWifiMapper;
import com.binarywang.demo.wx.miniapp.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/wifi")
@RequiredArgsConstructor
@Slf4j
public class WifiController {
    private final WxMaService maService;

    private final StoreWifiMapper storeWifiMapper;

    @PostMapping("/create")
    public ResponseResult create(@RequestBody StoreWifi storeWifi) throws WxErrorException {
        String base64Str=null;
        storeWifiMapper.insert(storeWifi);
        File file = this.maService.getQrcodeService().createWxaCodeUnlimit(storeWifi.getId(), "pages/connect/connect");
        try {
            byte[] bytes = FileUtils.readFileToByteArray(file);
            base64Str = Base64.getEncoder().encodeToString(bytes);
            base64Str = base64Str.replace("/[\r\n]/g","");
            base64Str = base64Str.replace(" ","");
            storeWifi.setQrCode(base64Str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        storeWifiMapper.updateById(storeWifi);
        return ResponseResult.SUCCESS(base64Str);
    }

    @GetMapping("/info")
    public ResponseResult info(String id) {
        return ResponseResult.SUCCESS(storeWifiMapper.selectById(id));
    }

    @GetMapping("/delete")
    public ResponseResult delete(String id) {
        return ResponseResult.SUCCESS(storeWifiMapper.deleteById(id));
    }

    @GetMapping("/list")
    public ResponseResult list(String userId) {
        QueryWrapper<StoreWifi> wrapper = Wrappers.<StoreWifi>query().eq("create_user", userId);
        return ResponseResult.SUCCESS(storeWifiMapper.selectList(wrapper));
    }
}
