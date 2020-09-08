package com.medsys.nis.maintain.mapper;

import com.medsys.nis.maintain.entity.MedEmrCodeDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 编码值表操作
 *
 * @ClassName IMedEmrCodeMapper
 * @Author zhuzhh
 * @Date 2020/7/22
 */
@Mapper
@Repository
public interface IMedEmrCodeMapper {
    /**
     * 查询全部根节点编码
     *
     * @param hospitalCode 院区编码
     * @return List<MedEmrCodeDO>
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    List<MedEmrCodeDO> queryRootCode(@Param("hospitalCode") String hospitalCode);

    /**
     * 根据编码查询所有子节点
     *
     * @param code         编码值
     * @param hospitalCode 院区编码
     * @return MedEmrCodeDO
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    MedEmrCodeDO queryCodeTreeByCode(@Param("code") String code, @Param("hospitalCode") String hospitalCode);

    /**
     * 根据编码值查询此编码实体(不包含子集)
     *
     * @param code         编码值
     * @param hospitalCode 院区编码
     * @return MedEmrCodeDO
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    MedEmrCodeDO queryCodeByCode(@Param("code") String code, @Param("hospitalCode") String hospitalCode);

    /**
     * 根据父id查询字节点编码
     *
     * @param parentId     父id
     * @param hospitalCode 院区编码
     * @return List<MedEmrCodeDO>
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    List<MedEmrCodeDO> queryChildByParentId(@Param("parentId") Long parentId, @Param("hospitalCode") String hospitalCode);

    /**
     * 新增一条编码数据
     *
     * @param medEmrCodeDO 编码数据实体类
     * @return int
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    int insertCode(MedEmrCodeDO medEmrCodeDO);

    /**
     * 修改一条编码数据
     *
     * @param medEmrCodeDO 编码数据实体类
     * @return int
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    int updateCode(MedEmrCodeDO medEmrCodeDO);

    /**
     * 停用/启用一条编码数据
     *
     * @param id      编码id
     * @param isValid 启用/停用
     * @return int
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    int changeCodeState(@Param("id") Long id, @Param("isValid") Boolean isValid);

}
