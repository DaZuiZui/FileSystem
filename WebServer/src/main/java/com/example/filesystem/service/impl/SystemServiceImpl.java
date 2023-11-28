package com.example.filesystem.service.impl;


import com.alibaba.fastjson2.JSONArray;
import com.example.filesystem.mapper.UserMapper;
import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.service.SystemService;
import com.example.filesystem.util.JwtUtil;
import com.example.filesystem.util.ThreadLocalUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * 系统接口实现类
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Value("${filePath}")
    private String path;
    @Value("${projecturl}")
    private String projecturl;



    /**
     * 鉴权
     * @param token
     * @return
     */
    @Override
    public ResponseVo auth(String token) {
        try {
            Map<String, Object> map = JwtUtil.analysis(token);
//            String id = (String) analysis.get("id");
//            Long userId = Long.valueOf(id);
//            User user = userMapper.findById(userId);
            ThreadLocalUtil.mapThreadLocalOfJWT.get().put("userinfo",map);
            System.out.println(ThreadLocalUtil.mapThreadLocalOfJWT);
            return new ResponseVo(null,map,"0x200");
        } catch (Exception e) {
            //e.printStackTrace();
            ThreadLocalUtil.mapThreadLocal.get().put("error","身份验证过期");
            ThreadLocalUtil.mapThreadLocal.get().put("code", "0x600");
            return new ResponseVo("身份登入验证过期",null,"0x203");
        }
    }

    /**
     * @author bryan yang 2023 10-12
     * 文件下载
     */
    @Override
    @ApiOperation("文件下载")
    @GetMapping(value ="/getimage",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@RequestParam("imgUrl") String imgUrl) throws IOException{

        File file = new File(path+"/"+imgUrl);

        FileInputStream inputStream = new FileInputStream(file);

        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes, 0, inputStream.available());

        return bytes;
    }

    /**
     * @author bryan yang 2023 10-12
     * 非幂等性处理
     * @return
     */
    @Override
    public String getNonPower() {
        return "";
    }

    /**
     * @author bryan yang 2023 10-12
     * 上传图片
     */
    @Override
    public String imgUpDown(@RequestParam("file") MultipartFile file, @RequestParam("token")String token) throws IOException{
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的图片才能上传，否则拒绝保存。
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生图片替换，这里使用了文件名重新生成
        fileName = UUID.randomUUID()+suffixName;

        //获取username
        Map<String, Object> analysis = JwtUtil.analysis(token);
        String id = (String) analysis.get("id");

        File saveFilePath = new File(path+""+id+"/");
        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
        if (!saveFilePath.exists()){
            saveFilePath.mkdirs();
        }

        file.transferTo(new File(path+""+id+"/"+fileName));
        System.err.println("??");
        return JSONArray.toJSONString(new ResponseVo<>("success",projecturl+"/system/getimage?imgUrl="+id+"/"+fileName,"0x200"));
    }
}