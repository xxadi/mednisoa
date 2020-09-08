package com.medsys.nis.common.bean;

import com.medsys.nis.common.config.ResultDetailEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回数据实体类
 *
 * @ClassName ResponseDTO
 * @Author zhuzhh
 * @Date 2020/7/20
 */
@ApiModel(value = "com.medsys.emr.common.bean.ResponseDTO", description = "返回值实体类，包含状态码，状态描述以及返回数据")
public class ResponseDTO<T> {
    /**
     * 状态码
     */
    @ApiModelProperty("状态码")
    private String code;
    /**
     * 状态描述
     */
    @ApiModelProperty("状态描述")
    private String message;
    /**
     * 返回数据实体
     */
    @ApiModelProperty("返回数据实体")
    private T data;

    /**
     * 请求产生错误时返回值的构造参数
     *
     * @param programCode      应用标识编码
     * @param moduleCode       模块编码
     * @param resultDetailEnum 操作结果枚举,包含状态码
     * @param message          状态描述
     */
    public ResponseDTO(String programCode, String moduleCode, ResultDetailEnum resultDetailEnum, String message) {
        this.code = programCode + moduleCode + resultDetailEnum.getCode();
        this.message = message;
        this.data = null;
    }

    /**
     * 请求成功时返回值的构造参数
     *
     * @param data 数据实体
     */
    public ResponseDTO(T data) {
        this.code = ResultDetailEnum.SUCCESS.getCode();
        this.message = "成功";
        this.data = data;
    }


    @Override
    public String toString() {
        return "ResponseDTO{" +
                "code='" + code + '\'' +
                ", status='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
