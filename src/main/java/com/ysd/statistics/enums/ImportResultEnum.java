package com.ysd.statistics.enums;

import lombok.Getter;

@Getter
public enum ImportResultEnum {
	
	SUCCESS(0, "成功"),
	
	STUNO_ISEXISTS(1, "学生学号已存在"),
    
	STU_CARDNO_ISEXISTS(2, "学生卡号已存在"),
	
	STU_SEX_ERROR(3, "学生性别不正确"),
	
    ;
    
    private Integer code;
    
    private String message;

    private ImportResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
	
}
