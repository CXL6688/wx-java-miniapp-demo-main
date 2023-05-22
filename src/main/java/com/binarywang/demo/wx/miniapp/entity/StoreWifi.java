package com.binarywang.demo.wx.miniapp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_storewifi")
public class StoreWifi {
    @TableId
    private String id;
    private String storeName;
    private String wifiSsid;
    private String wifiPassword;
    private String storeUrl;
    private String qrCode;
    private String createUser;
}
