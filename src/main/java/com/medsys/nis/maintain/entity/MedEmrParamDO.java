package com.medsys.nis.maintain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 参数表实体类
 *
 * @ClassName MedEmrParamDO
 * @Author zhuzhh
 * @Date 2020/7/20
 */
@ApiModel(value = "com.medsys.emr.maintain.entity.MedEMRParamDO", description = "参数表实体类")
public class MedEmrParamDO {
    /**
     * 主键，序列自增
     */
    @ApiModelProperty("主键，序列自增(新增时无需客户端传入)")
    private Long id;
    /**
     * 参数名称
     */
    @ApiModelProperty("参数名称")
    private String name;
    /**
     * 参数编码
     */
    @ApiModelProperty("参数编码")
    private String code;
    /**
     * 参数值
     */
    @ApiModelProperty("参数值")
    private String value;
    /**
     * 参数类型
     */
    @ApiModelProperty("参数类型")
    private String type;
    /**
     * 参数备注
     */
    @ApiModelProperty("参数备注")
    private String memo;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间(无需客户端传入)")
    private Date createTime;
    /**
     * 操作者编码
     */
    @ApiModelProperty("操作者编码")
    private String operCode;
    /**
     * 操作者名称
     */
    @ApiModelProperty("操作者名称")
    private String operName;
    /**
     * 操作时间
     */
    @ApiModelProperty("操作时间(无需客户端传入)")
    private Date operTime;
    /**
     * 院区编码
     */
    @ApiModelProperty("院区编码")
    private String hospitalCode;

    @Override
    public String toString() {
        return "MedEmrParamDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                ", type='" + type + '\'' +
                ", memo='" + memo + '\'' +
                ", createTime=" + createTime +
                ", operCode='" + operCode + '\'' +
                ", operName='" + operName + '\'' +
                ", operTime=" + operTime +
                ", hospitalCode='" + hospitalCode + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }
}
