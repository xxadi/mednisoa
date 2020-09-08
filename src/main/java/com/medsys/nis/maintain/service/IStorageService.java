package com.medsys.nis.maintain.service;

import com.medsys.nis.common.bean.CUDResultBean;
import com.medsys.nis.maintain.entity.MedEmrCodeDO;
import com.medsys.nis.maintain.entity.MedEmrParamDO;

import java.util.List;

/**
 * 维护模块-基础数据维护业务层相关方法
 *
 * @ClassName IStorageService
 * @Author zhuzhh
 * @Date 2020/7/20
 */
public interface IStorageService {
    /**
     * 查询全部参数配置
     *
     * @param hospitalCode 院区编码
     * @return List<MedEMRParamDO>
     * @Author zhuzhh
     * @Date 2020/7/20
     */
    List<MedEmrParamDO> queryAllParam(String hospitalCode);

    /**
     * 根据参数编码查询某条参数
     *
     * @param code         参数编码
     * @param hospitalCode 院区编码
     * @return MedEMRParamDO
     * @Author zhuzhh
     * @Date 2020/7/20
     */
    MedEmrParamDO queryParamByCode(String code, String hospitalCode);

    /**
     * 新增一条参数
     *
     * @param medEmrParamDO 参数实体
     * @return int
     * @Author zhuzhh
     * @Date 2020/7/20
     */
    CUDResultBean insertParam(MedEmrParamDO medEmrParamDO);

    /**
     * 修改参数
     *
     * @param medEmrParamDO 参数实体
     * @return int
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    CUDResultBean  updateParam(MedEmrParamDO medEmrParamDO);

    /**
     * 根据唯一标识删除编码
     *
     * @param id 主键
     * @return int
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    CUDResultBean  deleteParam(Long id);


    /**
     * 查询全部根节点编码
     *
     * @param hospitalCode 院区编码
     * @return List<MedEmrCodeDO>
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    List<MedEmrCodeDO> queryRootCode(String hospitalCode);

    /**
     * 根据编码查询所有子节点
     *
     * @param code         编码值
     * @param hospitalCode 院区编码
     * @return MedEmrCodeDO
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    MedEmrCodeDO queryCodeTreeByCode(String code, String hospitalCode);

    /**
     * 新增一条编码
     *
     * @param medEmrCodeDO 编码实体
     * @return CUDResultEnum
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    CUDResultBean  insertCode(MedEmrCodeDO medEmrCodeDO);

    /**
     * 修改一条编码
     *
     * @param medEmrCodeDO 编码实体
     * @return CUDResultEnum
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    CUDResultBean  updateCode(MedEmrCodeDO medEmrCodeDO);

    /**
     * 停用一条编码
     *
     * @param id      编码主键id
     * @param isValid 启用/停用
     * @return CUDResultEnum
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    CUDResultBean  changeCodeState(Long id, Boolean isValid);

}
