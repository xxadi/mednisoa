package com.medsys.nis.maintain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 编码制表实体类
 *
 * @ClassName MedEmrCode
 * @Author zhuzhh
 * @Date 2020/7/21
 */
@ApiModel(value = "MedEmrCodeDO", description = "编码制表实体类")
public class MedEmrCodeDO {
    /**
     * 主键，序列自增
     */
    @ApiModelProperty("主键，序列自增(新增时无需客户端传入)")
    private Long id;
    /**
     * 编码名称
     */
    @ApiModelProperty("编码名称")
    private String name;
    /**
     * 编码值
     */
    @ApiModelProperty("编码值")
    private String code;
    /**
     * 父id
     */
    @ApiModelProperty("父id")
    private Long parentId;
    /**
     * 排序码
     */
    @ApiModelProperty("排序码")
    private Integer sortNum;
    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用")
    private Boolean isValid;

    /**
     * 五笔码
     */
    @ApiModelProperty("五笔码")
    private String wbCode;
    /**
     * 拼音码
     */
    @ApiModelProperty("拼音码")
    private String spellCode;
    /**
     * 自定义码
     */
    @ApiModelProperty("自定义码")
    private String customCode;
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
    /**
     * 编码值的子编码集合
     */
    @ApiModelProperty("子编码集合")
    private List<MedEmrCodeDO> children;

    @Override
    public String toString() {
        return "MedEmrCodeDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentId=" + parentId +
                ", sortNum=" + sortNum +
                ", isValid=" + isValid +
                ", wbCode='" + wbCode + '\'' +
                ", spellCode='" + spellCode + '\'' +
                ", customCode='" + customCode + '\'' +
                ", createTime=" + createTime +
                ", operCode='" + operCode + '\'' +
                ", operName='" + operName + '\'' +
                ", operTime=" + operTime +
                ", hospitalCode='" + hospitalCode + '\'' +
                ", children=" + children +
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public String getWbCode() {
        return wbCode;
    }

    public void setWbCode(String wbCode) {
        this.wbCode = wbCode;
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    public String getCustomCode() {
        return customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode;
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

    public List<MedEmrCodeDO> getChildren() {
        return children;
    }

    public void setChildren(List<MedEmrCodeDO> children) {
        this.children = children;
    }
}
