package com.swjtu.girl.Exception;

import com.swjtu.girl.enums.ResultEnum;

/**
 * @author 李天峒
 * @date 2019/2/12 10:22
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}
