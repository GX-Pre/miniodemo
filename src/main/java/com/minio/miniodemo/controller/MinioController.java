package com.minio.miniodemo.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.minio.miniodemo.utils.MinioUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/minio")
@Api(tags = "minio测试",value = "minio测试")
public class MinioController {
    /**
     * minio测试接口--上传文件
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ApiOperation(value = "minio测试接口",notes = "minio测试接口")
    public @ResponseBody
    String minioTest(@RequestParam("file") MultipartFile multipartFile){
        MinioUtils.upload(multipartFile,"/images",null);
        return "上传成功！";
    }

    /**
     * minio测试接口-获取文件列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getbucket",method = RequestMethod.POST)
    @ApiOperation(value = "minio测试接口-获取文件列表",notes = "minio测试接口-获取文件列表")
    public @ResponseBody
    JSONArray minioTest2() throws Exception {
        return JSONUtil.parseArray(MinioUtils.listObjects("bucket20220404",null,true,false));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除minio文件",notes = "删除minio文件")
    public String deleteMinio() throws Exception {
        try {
            MinioUtils.removeObject("bucket20220404","第三次.jpg");
            return "删除成功！";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
