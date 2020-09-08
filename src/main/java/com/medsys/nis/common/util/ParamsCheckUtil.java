package com.medsys.nis.common.util;

import com.medsys.nis.common.bean.RequestDTO;
import com.medsys.nis.common.bean.ResponseDTO;
import com.medsys.nis.common.config.ConfigData;
import com.medsys.nis.common.config.ResultDetailEnum;

/**
 * 参数检查工具类
 *
 * @ClassName ParamsCheckUtil
 * @Author zhuzhh
 * @Date 2020/7/22
 */
public class ParamsCheckUtil {
    /**
     * 请求数据为ResponseDTO的错误检查方法
     *
     * @param requestDTO 请求实体
     * @param moduleCode  模块编码
     * @return ResponseBean<Object>  null表示请求参数无错误
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    public static <T> ResponseDTO<T> requestBeanErrorCheck(RequestDTO<?> requestDTO, String moduleCode) {
        if (requestDTO == null) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, moduleCode, ResultDetailEnum.PARAM_ERROR, "请求实体为空");
        }
        if (requestDTO.getIp() == null || requestDTO.getIp().isEmpty()) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, moduleCode, ResultDetailEnum.PARAM_ERROR, "ip地址为空");
        }
        if (requestDTO.getOperCode() == null || requestDTO.getOperCode().isEmpty()) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, moduleCode, ResultDetailEnum.PARAM_ERROR, "操作者编码为空");
        }
        if (requestDTO.getVer() == null || requestDTO.getVer().isEmpty()) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, moduleCode, ResultDetailEnum.PARAM_ERROR, "目标接口版本号为空");
        }
        if (requestDTO.getHospitalCode() == null || requestDTO.getHospitalCode().isEmpty()) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, moduleCode, ResultDetailEnum.PARAM_ERROR, "医院编码为空");
        }
        if (requestDTO.getData() == null) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, moduleCode, ResultDetailEnum.PARAM_ERROR, "请求数据实体为空");
        }
        return null;
    }
}
