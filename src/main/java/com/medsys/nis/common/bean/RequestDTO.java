package com.medsys.nis.common.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 请求数据实体类
 *
 * @ClassName RequestDTO
 * @Author zhuzhh
 * @Date 2020/7/20
 */
@ApiModel(value = "RequestDTO", description = "请求操作实体类，包含操作者ip，用户名，目标接口版本号以及请求数据")
public class RequestDTO<T> {
    /**
     * 请求者ip地址
     */
    @ApiModelProperty("请求者ip地址")
    private String ip;
    /**
     * 请求者编码
     */
    @ApiModelProperty("请求者编码")
    private String operCode;
    /**
     * 请求者名称
     */
    @ApiModelProperty("请求者名称")
    private String operName;

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    /**
     * 请求目标接口版本号
     */
    @ApiModelProperty("请求目标接口版本号")
    private String ver;
    /**
     * 院区编码
     */
    @ApiModelProperty("院区编码")
    private String hospitalCode;
    /**
     * 请求数据
     */
    @ApiModelProperty("请求数据")
    private T data;

    @Override
    public String toString() {
        return "RequestDTO{" +
                "ip='" + ip + '\'' +
                ", operCode='" + operCode + '\'' +
                ", operName='" + operName + '\'' +
                ", ver='" + ver + '\'' +
                ", hospitalCode='" + hospitalCode + '\'' +
                ", data=" + data +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
