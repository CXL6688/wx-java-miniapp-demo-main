DROP TABLE IF EXISTS t_storewifi;
CREATE TABLE t_storewifi
(
    id VARCHAR(40) NOT NULL COMMENT '主键ID',
    store_name VARCHAR(100) NULL DEFAULT NULL COMMENT '店铺名称',
    wifi_ssid VARCHAR(100) NULL DEFAULT NULL COMMENT 'wifi名称',
    wifi_password VARCHAR(100) NULL DEFAULT NULL COMMENT 'wifi密码',
    store_url longtext NULL DEFAULT NULL COMMENT '推广地址',
    qr_code longtext NULL DEFAULT NULL COMMENT '二维码base64',
    create_user VARCHAR(100) NULL DEFAULT NULL COMMENT 'wifi密码',
    PRIMARY KEY (id)
);