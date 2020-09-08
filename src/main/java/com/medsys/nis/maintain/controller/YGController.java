package com.medsys.nis.maintain.controller; /**
 * Created by Super on 2020/7/31.
 */

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.medsys.nis.common.util.JsonDateUtils;
import com.medsys.nis.common.util.UUIDUtils;
import com.medsys.nis.maintain.bean.FileResult;
import com.medsys.nis.maintain.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/7/31 13:43
 */

@RestController
@RequestMapping("medemr/maintain/yg")
public class YGController {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(StorageController.class);
    @Autowired
    private LoginService loginService;

    //
//    /**
//     * 科室数据操作
//     */
//    @Autowired
//    private IDeptService deptService;
//
//
//    @ApiOperation("根据yg")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "deptCode", value = "科室编码", dataType = "String", required = true, example = "1"),
//            @ApiImplicitParam(name = "hospitalCode", value = "院区编码", dataType = "String", required = true, example = "1"),
//            @ApiImplicitParam(name = "isValid", value = "是否启用", dataType = "String" , required = true, example = "1")
//    })
    @GetMapping("queryYG")
    public String reSromsg(String deptCode, String isValid, String hospitalCode) {
        JsonObject object = new JsonObject();
        object.addProperty("id", 1);
        object.addProperty("name", "系统管理");
        object.addProperty("pid", 0);
        object.addProperty("paname", "");
        object.addProperty("descpt", "系统管理");
        object.addProperty("url", "http://127.0.0.1:8848/YGOA/index.html");
        object.addProperty("createTime", "2018-11-30 10:27:34");
        object.addProperty("updateTime", "2018-11-30 10:27:34");
        object.addProperty("delFlag", 1);
        JsonArray array = new JsonArray();
        JsonObject language1 = new JsonObject();
        language1.addProperty("id", 2);
        language1.addProperty("name", "账号管理");
        language1.addProperty("pid", 1);
        language1.addProperty("paname", "");
        language1.addProperty("descpt", "系统管理");
        language1.addProperty("url", "http://127.0.0.1:8848/YGOA/index.html");
        language1.addProperty("createTime", "2018-11-30 10:27:34");
        language1.addProperty("updateTime", "2018-11-30 10:27:34");
        language1.addProperty("delFlag", 1);
        array.add(language1);
//        JsonObject language2=new JsonObject();
//        language1.addProperty("authId", "10012");
//        language1.addProperty("bigAuth", "1");
//        language1.addProperty("authUser", "查询");
//        language1.addProperty("url", "http://178.0.0.1:8013//toUser");
//        array.add(language2);
        object.add("childrens", array);
        JsonObject object1 = new JsonObject();
        JsonArray array1 = new JsonArray();
        array1.add(object);
        object1.add("menu", array1);
        object1.addProperty("token","123456");
        return object1.toString();
    }

    @RequestMapping("queryYG1")
    @ResponseBody
    public FileResult reSromsg1(@RequestParam("picture") MultipartFile[] picture) {
        System.out.println(JsonDateUtils.getJson( new Date()));
//        System.out.println(JsonDataUtils.getJson(picture));
        System.out.println("您已进入图片上传服务");
        System.out.println("picture" + picture.length);
        System.out.println(picture);
        JSONObject jsonObject = null;

        //获取文件在服务器的储存位置
        String path = "G://jsp学习";
        File filePath = new File(path);
        logger.info("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            logger.info("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        boolean flag = true;
        for (int i = 0; i < picture.length; i++) {
            //获取原始文件名称(包含格式)
            String originalFileName = picture[i].getOriginalFilename();
            logger.info("原始文件名称：" + originalFileName);

            //获取文件类型，以最后一个`.`为标识
            String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            logger.info("文件类型：" + type);
            //获取文件名称（不包含格式）
            String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

            String fileName = UUIDUtils.getUUID32() + name + "." + type;
            logger.info("新文件名称：" + fileName);

            //在指定路径下创建一个文件
            File targetFile = new File(path, fileName);
            logger.info("图片地址：" + path + "/" + fileName);
            //将文件保存到服务器指定位置
            try {
                picture[i].transferTo(targetFile);
                logger.info("上传成功");
                //将文件在服务器的存储路径返回
//                return new FileResult(true,fileName,path+"/"+fileName);
            } catch (IOException e) {
                logger.info("上传失败");
                e.printStackTrace();
//                return new FileResult(false, "上传失败","");
            }
        }
        if (flag) {
            return new FileResult(true, "", path + "/" + "");
        } else {
            return new FileResult(false, "上传失败", "");
        }

    }


//    @PostMapping("del.json")
//    @ResponseBody
//    @Operation("文件删除")
//    public String delfile(@RequestParam Integer id){
//        TjrFile tjrFile =  fileService.findOne(id);
//        try {
//            fileService.del(id);
//            File file = new File(filePath+tjrFile.getUuidname());
//            if (file.delete()) {
//                logger.info(file.getName() + "is deleted");
//                return "true";
//            } else {
//                logger.info("Delete failed.");
//                return "false";
//            }
//        } catch (Exception e) {
//            logger.info("Exception occured");
//            e.printStackTrace();
//            return "false";
//        }
//    }
}
