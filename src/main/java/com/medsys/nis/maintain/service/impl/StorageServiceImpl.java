package com.medsys.nis.maintain.service.impl;

import com.medsys.nis.common.bean.CUDResultBean;
import com.medsys.nis.maintain.entity.MedEmrCodeDO;
import com.medsys.nis.maintain.entity.MedEmrParamDO;
import com.medsys.nis.maintain.mapper.IMedEmrCodeMapper;
import com.medsys.nis.maintain.service.IStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 维护模块service层实现类
 *
 * @ClassName StorageServiceImpl
 * @Author zhuzhh
 * @Date 2020/7/20
 */
@Service
public class StorageServiceImpl implements IStorageService {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(StorageServiceImpl.class);
    /**
     * 参数表操作
     */
//    @Autowired
//    private IMedEmrParamMapper medEmrParamMapper;
    /**
     * 编码值表操作
     */
    @Autowired
    private IMedEmrCodeMapper medEmrCodeMapper;

    /**
     * @Author zhuzhh
     * @Date 2020/7/23
     */
//    @Override
//    public List<MedEmrParamDO> queryAllParam(String hospitalCode) {
//        return medEmrParamMapper.queryAllParam(hospitalCode);
//    }

    /**
     * @Author zhuzhh
     * @Date 2020/7/23
     */
//    @Override
//    public MedEmrParamDO queryParamByCode(String code, String hospitalCode) {
//        MedEmrParamDO medEMRParamDO;
//        try {
//            medEMRParamDO = medEmrParamMapper.queryParamByCode(code, hospitalCode);
//        } catch (Exception e) {
//            LOG.error("根据参数编码查询某条参数时,数据库查询异常,请检查数据是否规范,目标表:MEDEMR_PARAM", e);
//            throw e;
//        }
//        return medEMRParamDO;
//    }

    /**
     * @Author zhuzhh
     * @Date 2020/7/23
     */
//    @Override
//    public CUDResultEnum insertParam(MedEmrParamDO medEmrParamDO) {
//        // 判断此编码值在库中是否存在,若已存在,则允许插入此新数据
//        MedEmrParamDO hasDo = medEmrParamMapper.queryParamByCode(medEmrParamDO.getCode(), medEmrParamDO.getHospitalCode());
//        if (hasDo != null) {
//            return CUDResultEnum.PARAM_ERROR;
//        }
//        medEmrParamMapper.insertParam(medEmrParamDO);
//        return CUDResultEnum.SUCCESS;
//    }

    /**
     * @Author zhuzhh
     * @Date 2020/7/23
     */
//    @Override
//    public CUDResultEnum updateParam(MedEmrParamDO medEmrParamDO) {
//        /*
//        判断原数据中是否有此编码值,若无此编码值,则正常进行修改
//        若已有此编码值,判断是否为要被修改的数据,若是即将被修改的数据,则正常进行修改
//        否则, 不允许进行修改, 编码值冲突
//         */
//        MedEmrParamDO oldDo = medEmrParamMapper.queryParamByCode(medEmrParamDO.getCode(), medEmrParamDO.getHospitalCode());
//        if (oldDo != null && !Objects.equals(oldDo.getId(), medEmrParamDO.getId())) {
//            return CUDResultEnum.PARAM_ERROR;
//        }
//        int num = medEmrParamMapper.updateParam(medEmrParamDO);
//        if (num <= 0) {
//            return CUDResultEnum.PARAM_ERROR;
//        }
//        return CUDResultEnum.SUCCESS;
//    }

    /**
     * @Author zhuzhh
     * @Date 2020/7/23
     */
//    @Override
//    public CUDResultEnum deleteParam(Long id) {
//        int num = medEmrParamMapper.deleteParam(id);
//        if (num <= 0) {
//            return CUDResultEnum.PARAM_ERROR;
//        }
//        return CUDResultEnum.SUCCESS;
//    }

    /**
     * @Author zhuzhh
     * @Date 2020/7/23
     */
//    @Override
//    public List<MedEmrCodeDO> queryRootCode(String hospitalCode) {
//        return medEmrCodeMapper.queryRootCode(hospitalCode);
//    }

    @Override
    public List<MedEmrParamDO> queryAllParam(String hospitalCode) {
        return null;
    }

    @Override
    public MedEmrParamDO queryParamByCode(String code, String hospitalCode) {
        return null;
    }

    @Override
    public CUDResultBean insertParam(MedEmrParamDO medEmrParamDO) {
        return null;
    }

    @Override
    public CUDResultBean updateParam(MedEmrParamDO medEmrParamDO) {
        return null;
    }

    @Override
    public CUDResultBean deleteParam(Long id) {
        return null;
    }

    @Override
    public List<MedEmrCodeDO> queryRootCode(String hospitalCode) {
        return null;
    }

    /**
     * @Author zhuzhh
     * @Date 2020/7/23
     */
    @Override
    public MedEmrCodeDO queryCodeTreeByCode(String code, String hospitalCode) {
        MedEmrCodeDO medEmrCodeDO;
        try {
            medEmrCodeDO = medEmrCodeMapper.queryCodeTreeByCode(code, hospitalCode);
        } catch (Exception e) {
            LOG.error("根据编码查询所有子节点时,数据库查询异常，请检查数据是否规范,目标表:MEDEMR_CODE", e);
            throw e;
        }
        return medEmrCodeDO;
    }

    @Override
    public CUDResultBean insertCode(MedEmrCodeDO medEmrCodeDO) {
        return null;
    }

    @Override
    public CUDResultBean updateCode(MedEmrCodeDO medEmrCodeDO) {
        return null;
    }

    @Override
    public CUDResultBean changeCodeState(Long id, Boolean isValid) {
        return null;
    }

    /**
     * @Author zhuzhh
     * @Date 2020/7/23
     */
//    @Override
//    public CUDResultEnum insertCode(MedEmrCodeDO medEmrCodeDO) {
//        MedEmrCodeDO oldDo = medEmrCodeMapper.queryCodeByCode(medEmrCodeDO.getCode(), medEmrCodeDO.getHospitalCode());
//        if (oldDo != null) {
//            return CUDResultEnum.PARAM_ERROR;
//        }
//        medEmrCodeMapper.insertCode(medEmrCodeDO);
//        return CUDResultEnum.SUCCESS;
//    }


//    public CUDResultEnum updateCode(MedEmrCodeDO medEmrCodeDO) {
//        /*
//        判断原数据中是否有此编码值,若无此编码值,则正常进行修改
//        若已有此编码值,判断是否为要被修改的数据,若是即将被修改的数据,则正常进行修改
//        否则, 不允许进行修改, 编码值冲突
//         */
//        MedEmrCodeDO oldDo = medEmrCodeMapper.queryCodeByCode(medEmrCodeDO.getCode(), medEmrCodeDO.getHospitalCode());
//        if (oldDo != null && !Objects.equals(oldDo.getId(), medEmrCodeDO.getId())) {
//            return CUDResultEnum.PARAM_ERROR;
//        }
//        int num = medEmrCodeMapper.updateCode(medEmrCodeDO);
//        if (num <= 0) {
//            return CUDResultEnum.PARAM_ERROR;
//        }
//        return CUDResultEnum.SUCCESS;
//    }
//
//    /**
//     * @Author zhuzhh
//     * @Date 2020/7/23
//     */
//    @Override
//    public CUDResultEnum changeCodeState(Long id, Boolean isValid) {
//        if (id == null || isValid == null) {
//            return CUDResultEnum.PARAM_ERROR;
//        }
//        int num = medEmrCodeMapper.changeCodeState(id, isValid);
//        if (num <= 0) {
//            return CUDResultEnum.PARAM_ERROR;
//        }
//        return CUDResultEnum.SUCCESS;
//    }

}
