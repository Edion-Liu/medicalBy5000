package com.chuangbu.common.enums;

public enum SwitchEnum {
	
	ON("1","开启"),OFF("0","关闭") ;

    private String code;
    private String desc;

    SwitchEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return String.format("Switch{\"code\":\"%s\", \"desc\":\"%s\"}'", code,desc);
    }
    
}
