package com.example.filesystem.service.impl;

import com.example.filesystem.mapper.FileMapper;
import com.example.filesystem.pojo.File;
import com.example.filesystem.pojo.bo.FindOwnFileBo;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.service.FileService;
import com.example.filesystem.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    /**
     * @author hln 2023-11-28
     *      显示自己的文件
     * @param findOwnFileBo
     * @return
     */
    @Override
    public ResponseVo findOwnFile(FindOwnFileBo findOwnFileBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("查询失败",null,"0x501");
        }

        File file = fileMapper.findOwnFile(findOwnFileBo);

        return null;
    }

}
