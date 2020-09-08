package com.medsys.nis.maintain.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medsys.nis.common.bean.CUDResultBean;
import com.medsys.nis.common.bean.RequestDTO;
import com.medsys.nis.common.bean.ResponseDTO;
import com.medsys.nis.common.config.ConfigData;
import com.medsys.nis.common.config.ResultDetailEnum;
import com.medsys.nis.common.util.ParamsCheckUtil;
import com.medsys.nis.common.util.ResultAnalyseUtil;
import com.medsys.nis.maintain.entity.MedEmrCodeDO;
import com.medsys.nis.maintain.entity.MedEmrParamDO;
import com.medsys.nis.maintain.service.IStorageService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 维护模块-基础数据维护相关接口
 *
 * @ClassName StorageController
 * @Author zhuzhh
 * @Date 2020/7/20
 */
@RestController
@RequestMapping("medemr/maintain/storage")
public class StorageController {
    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(StorageController.class);
    /**
     * 模块编码
     */
    private static final String MODULE_CODE = "001";

    /**
     * 基础数据维护操作
     */
    @Autowired
    private IStorageService storageService;

    /**
     * 分页查询全部参数配置
     *
     * @param num          查询页数
     * @param size         每页数量
     * @param hospitalCode 院区编码
     * @return ResponseDTO<PageInfo < MedEmrParamDO>>
     * @Author zhuzhh
     * @Date 2020/7/20
     */
    @ApiOperation("分页查询全部参数配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "查询页数", dataType = "Integer", required = false, example = "1"),
            @ApiImplicitParam(name = "size", value = "每页数量", dataType = "Integer", required = false, example = "5"),
            @ApiImplicitParam(name = "hospitalCode", value = "院区编码", dataType = "String", required = true, example = "001")
    })
    @GetMapping("queryAllParamByPage")
    public ResponseDTO<PageInfo<MedEmrParamDO>> queryAllParamByPage(Integer num, Integer size, String hospitalCode) {
        if (num == null || num.equals(0)) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, StorageController.MODULE_CODE,
                    ResultDetailEnum.PARAM_ERROR, "查询页数有误");
        }
        if (size == null || size.equals(0)) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, StorageController.MODULE_CODE,
                    ResultDetailEnum.PARAM_ERROR, "每页数量有误");
        }
        if (hospitalCode == null || hospitalCode.isEmpty()) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, StorageController.MODULE_CODE,
                    ResultDetailEnum.PARAM_ERROR, "院区编码为空");
        }
        PageHelper.startPage(num, size);
        List<MedEmrParamDO> medEmrParamDOList = storageService.queryAllParam(hospitalCode);
        PageInfo<MedEmrParamDO> pageInfo = new PageInfo<>(medEmrParamDOList);
        return new ResponseDTO<>(pageInfo);
    }

    /**
     * 根据参数编码查询某参数
     *
     * @param code         参数编码
     * @param hospitalCode 院区编码
     * @return ResponseDTO<MedEMRParamDO>
     * @Author zhuzhh
     * @Date 2020/7/20
     */
    @ApiOperation("根据参数编码查询某参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "参数编码", dataType = "String", required = true, example = "001"),
            @ApiImplicitParam(name = "hospitalCode", value = "院区编码", dataType = "String", required = true, example = "001")
    })
    @GetMapping("queryParamByCode")
    public ResponseDTO<MedEmrParamDO> queryParamByCode(String code, String hospitalCode) {
        if (hospitalCode == null || hospitalCode.isEmpty()) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, StorageController.MODULE_CODE,
                    ResultDetailEnum.PARAM_ERROR, "院区编码为空");
        }
        if (code == null || code.isEmpty()) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, StorageController.MODULE_CODE,
                    ResultDetailEnum.PARAM_ERROR, "参数编码为空");
        }
        MedEmrParamDO medEmrParamDO;
        try {
            // 因code字段并未设置唯一约束，防止数据异常导致程序报错，在此做异常处理
            medEmrParamDO = storageService.queryParamByCode(code, hospitalCode);
        } catch (Exception e) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, StorageController.MODULE_CODE,
                    ResultDetailEnum.QUERY_FAIL, "数据库查询异常，请检查数据是否规范");
        }
        return new ResponseDTO<>(medEmrParamDO);
    }

    /**
     * 新增参数
     *
     * @param requestDTO RequestDTO<MedEmrParamDO>
     * @return ResponseDTO<Boolean>
     * @Author zhuzhh
     * @Date 2020/7/20
     */
    @ApiOperation("新增一条参数")
    @PutMapping("insertParam")
    public ResponseDTO<Boolean> insertParam(@RequestBody RequestDTO<MedEmrParamDO> requestDTO) {
        ResponseDTO<Boolean> errorResult = ParamsCheckUtil.requestBeanErrorCheck(requestDTO, StorageController.MODULE_CODE);
        if (errorResult != null) {
            return errorResult;
        }
        MedEmrParamDO medEmrParamDO = requestDTO.getData();
        CUDResultBean resultEnum = storageService.insertParam(medEmrParamDO);
        return ResultAnalyseUtil.CUDAnalyse(resultEnum, StorageController.MODULE_CODE);
    }

    /**
     * 修改某条参数
     *
     * @param requestDTO RequestDTO<MedEmrParamDO>
     * @return ResponseDTO<Boolean>
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    @ApiOperation("修改某条参数")
    @PostMapping("updateParam")
    public ResponseDTO<Boolean> updateParam(@RequestBody RequestDTO<MedEmrParamDO> requestDTO) {
        ResponseDTO<Boolean> errorResult = ParamsCheckUtil.requestBeanErrorCheck(requestDTO, StorageController.MODULE_CODE);
        if (errorResult != null) {
            return errorResult;
        }
        MedEmrParamDO medEmrParamDO = requestDTO.getData();
        CUDResultBean resultEnum = storageService.updateParam(medEmrParamDO);
        return ResultAnalyseUtil.CUDAnalyse(resultEnum, StorageController.MODULE_CODE);
    }

    /**
     * 删除某条参数
     *
     * @param requestDTO RequestDTO<Long>
     * @return ResponseDTO<Boolean>
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    @ApiOperation("删除某条参数")
    @DeleteMapping("deleteParam")
    public ResponseDTO<Boolean> deleteParam(@RequestBody RequestDTO<Long> requestDTO) {
        ResponseDTO<Boolean> errorResult = ParamsCheckUtil.requestBeanErrorCheck(requestDTO, StorageController.MODULE_CODE);
        if (errorResult != null) {
            return errorResult;
        }
        Long id = requestDTO.getData();
        CUDResultBean  resultEnum = storageService.deleteParam(id);
        return ResultAnalyseUtil.CUDAnalyse(resultEnum, StorageController.MODULE_CODE);
    }


    /**
     * 查询全部根节点编码列表(包含其子节点)
     *
     * @param hospitalCode 院区编码
     * @return ResponseDTO<List < MedEmrCodeDO>>
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    @ApiOperation("查询全部根节点编码列表(包含其子节点)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hospitalCode", value = "院区编码", dataType = "String", required = true, example = "001")
    })
    @GetMapping("queryRootCode")
    public ResponseDTO<List<MedEmrCodeDO>> queryRootCode(String hospitalCode) {
        if (hospitalCode == null || hospitalCode.isEmpty()) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, StorageController.MODULE_CODE,
                    ResultDetailEnum.HOSPITAL_CODE_ISNULL, "院区编码为空");
        }
        List<MedEmrCodeDO> medEmrCodeDOList = storageService.queryRootCode(hospitalCode);
        return new ResponseDTO<>(medEmrCodeDOList);
    }

    /**
     * 查询某编码的编码树
     *
     * @param code         查询编码
     * @param hospitalCode 院区编码
     * @return ResponseDTO<Boolean>
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    @ApiOperation("查询某编码的编码树")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "查询编码", dataType = "String", required = true, example = "001"),
            @ApiImplicitParam(name = "hospitalCode", value = "院区编码", dataType = "String", required = true, example = "001")
    })
    @GetMapping("queryCodeTreeByCode")
    public ResponseDTO<MedEmrCodeDO> queryCodeTreeByCode(String code, String hospitalCode) {
        if (hospitalCode == null || hospitalCode.isEmpty()) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, StorageController.MODULE_CODE,
                    ResultDetailEnum.HOSPITAL_CODE_ISNULL, "院区编码为空");
        }
        if (code == null || code.isEmpty()) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, StorageController.MODULE_CODE,
                    ResultDetailEnum.CODE_ID_ISNULL, "查询编码为空");
        }
        MedEmrCodeDO medEmrCodeDO;
        try {
            medEmrCodeDO = storageService.queryCodeTreeByCode(code, hospitalCode);
        } catch (Exception e) {
            return new ResponseDTO<>(ConfigData.PROGRAM_CODE, StorageController.MODULE_CODE,
                    ResultDetailEnum.QUERY_FAIL, "数据库查询异常，请检查数据是否规范");
        }
        return new ResponseDTO<>(medEmrCodeDO);
    }

    /**
     * 新增一项编码
     *
     * @param requestDTO RequestDTO<MedEmrCodeDO>
     * @return ResponseDTO<Boolean>
     * @Author zhuzhh
     * @Date 2020/7/20
     */
    @ApiOperation("新增一项编码")
    @PutMapping("insertCode")
    public ResponseDTO<Boolean> insertCode(@RequestBody RequestDTO<MedEmrCodeDO> requestDTO) {
        ResponseDTO<Boolean> errorResult = ParamsCheckUtil.requestBeanErrorCheck(requestDTO, StorageController.MODULE_CODE);
        if (errorResult != null) {
            return errorResult;
        }
        CUDResultBean resultEnum = storageService.insertCode(requestDTO.getData());
        return ResultAnalyseUtil.CUDAnalyse(resultEnum, StorageController.MODULE_CODE);
    }

    /**
     * 修改某项编码
     *
     * @param requestDTO RequestDTO<MedEmrCodeDO>
     * @return ResponseDTO<Boolean>
     * @Author zhuzhh
     * @Date 2020/7/22
     */
    @ApiOperation("修改某项编码")
    @PostMapping("updateCode")
    public ResponseDTO<Boolean> updateCode(@RequestBody RequestDTO<MedEmrCodeDO> requestDTO) {
        ResponseDTO<Boolean> errorResult = ParamsCheckUtil.requestBeanErrorCheck(requestDTO, StorageController.MODULE_CODE);
        if (errorResult != null) {
            return errorResult;
        }
        MedEmrCodeDO medEmrCodeDO = requestDTO.getData();
        CUDResultBean resultEnum = storageService.updateCode(medEmrCodeDO);
        return ResultAnalyseUtil.CUDAnalyse(resultEnum, StorageController.MODULE_CODE);
    }

//    /**
//     * 停用/启用某项编码
//     *
//     * @param requestDTO RequestDTO<DataStateDTO>
//     * @return ResponseDTO<Boolean>
//     * @Author zhuzhh
//     * @Date 2020/7/22
//     */
//    @ApiOperation("停用/启用某项编码")
//    @PostMapping("changeCodeState")
//    public ResponseDTO<Boolean> changeCodeState(@RequestBody RequestDTO<DataStateDTO> requestDTO) {
//        ResponseDTO<Boolean> errorResult = ParamsCheckUtil.requestBeanErrorCheck(requestDTO, StorageController.MODULE_CODE);
//        if (errorResult != null) {
//            return errorResult;
//        }
//        DataStateDTO dataStateDTO = requestDTO.getData();
//        CUDResultBean resultEnum = storageService.changeCodeState(dataStateDTO.getId(), dataStateDTO.getIsValid());
//        return ResultAnalyseUtil.CUDAnalyse(resultEnum, StorageController.MODULE_CODE);
//    }

}
