package com.medsys.nis.common.util;

import com.medsys.nis.common.bean.CUDResultBean;
import com.medsys.nis.common.bean.ResponseDTO;
import com.medsys.nis.common.config.ConfigData;
import com.medsys.nis.common.config.ResultDetailEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 结果分析工具类
 *
 * @ClassName ResultAnalyseUtil
 * @Author zhuzhh
 * @Date 2020/7/22
 */
public class ResultAnalyseUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ResultAnalyseUtil.class);

    /**
     * 根据增删改业务的返回值结果组装controller层返回值内容
     *
     * @param resultBean 增删改业务的返回值实体类
     * @return ResponseBean<Boolean>
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    public static ResponseDTO<Boolean> CUDAnalyse(CUDResultBean resultBean, String moduleCode) {
        ResultDetailEnum resultDetailEnum = resultBean.getDetailEnum();
        if (resultDetailEnum == ResultDetailEnum.SUCCESS) {
            return new ResponseDTO<>(true);
        }
        return new ResponseDTO<>(ConfigData.PROGRAM_CODE, moduleCode, resultDetailEnum, resultBean.getMessage());
    }
}
