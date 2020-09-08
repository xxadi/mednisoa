package com.medsys.nis.common.bean;


import com.medsys.nis.common.config.ResultDetailEnum;

/**
 * 增删改业务的返回值实体类
 *
 * @ClassName CUDResultBean
 * @Author zhuzhh
 * @Date 2020/7/30
 */
public class CUDResultBean {
    /**
     * 操作结果枚举,包含状态码
     */
    private ResultDetailEnum detailEnum;
    /**
     * 状态描述
     */
    private String message;

    /**
     * 获取操作成功的返回结果
     *
     * @return CUDResultBean
     * @Author zhuzhh
     * @Date 2020/7/30
     */
    public static CUDResultBean getSuccessResult() {
        CUDResultBean bean = new CUDResultBean();
        bean.setDetailEnum(ResultDetailEnum.SUCCESS);
        bean.setMessage("操作成功");
        return bean;
    }

    /**
     * 获取操作失败的返回结果
     *
     * @param resultDetailEnum 操作结果枚举
     * @param message          状态描述
     * @return CUDResultBean
     * @Author zhuzhh
     * @Date 2020/7/30
     */
    public static CUDResultBean getErrorResult(ResultDetailEnum resultDetailEnum, String message) {
        CUDResultBean bean = new CUDResultBean();
        bean.setDetailEnum(resultDetailEnum);
        bean.setMessage(message);
        return bean;
    }

    @Override
    public String toString() {
        return "CUDResultBean{" +
                "detailEnum=" + detailEnum +
                ", message='" + message + '\'' +
                '}';
    }

    public ResultDetailEnum getDetailEnum() {
        return detailEnum;
    }

    public void setDetailEnum(ResultDetailEnum detailEnum) {
        this.detailEnum = detailEnum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
