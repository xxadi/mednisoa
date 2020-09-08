package com.medsys.nis.common.config;

/**
 * 操作结果枚举,包含状态码
 */
public enum ResultDetailEnum {
    /**
     * 数据库插入失败
     */
    INSERT_FAIL("B0001"),
    /**
     * 数据库删除失败
     */
    DELETE_FAIL("B0002"),
    /**
     * 数据库修改失败
     */
    UPDATE_FAIL("B0003"),
    /**
     * 编码值在库中已存在
     */
    CODE_IS_HAVE("B0100"),


    /**
     * 参数有误
     */
    PARAM_ERROR("P0001"),
    /**
     * 请求数据为空
     */
    REQ_IS_NULL("P0010"),
    /**
     * ip地址为空
     */
    IP_IS_NULL("P0011"),
    /**
     * 操作者编码为空
     */
    OPERCODE_IS_NULL("P0012"),
    /**
     * 操作者名称为空
     */
    OPERNAME_IS_NULL("P0013"),
    /**
     * 目标接口版本号为空
     */
    VER_IS_NULL("P0014"),
    /**
     * 院区编码为空
     */
    HOSPITAL_CODE_ISNULL("P0015"),
    /**
     * 请求数据实体为空
     */
    DATA_IS_NULL("P0016"),
    /**
     * 查询页数有误
     */
    PAGE_NUM_ERROR("P0017"),
    /**
     * 每页数量有误
     */
    PAGE_SIZE_ERROR("P0018"),
    /**
     * 备选项id为空
     */
    ITEM_ID_ISNULL("P0101"),

    /**
     * 科室编码为空
     */
    DEPT_ID_ISNULL("P0102"),

    /**
     * 人员编码为空
     */
    EMPLOYEE_ID_ISNULL("P0103"),
    /**
     * 参数编码为空
     */
    PARAM_CODE_ID_ISNULL("P0104"),
    /**
     * 查询编码为空
     */
    CODE_ID_ISNULL("P0105"),
    /**
     * 模板类型编码为空
     */
    TPL_TYPE_CODE_ISNULL("P0106"),
    /**
     * 模板ID为空
     */
    TPL_ID_ISNULL("P0107"),


    /**
     * 启用/停用时,id/isValid参数为空
     */
    CHANGE_STATE_PARAM_ISNULL("P0111"),


    /**
     * 数据库查询失败
     */
    QUERY_FAIL("D0001"),


    /**
     * 服务端未知异常
     */
    SERVER_ERROR("B0001"),
    /**
     * 操作成功
     */
    SUCCESS("200");

    private String code;

    ResultDetailEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
