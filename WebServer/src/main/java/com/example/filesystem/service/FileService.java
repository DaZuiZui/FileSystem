package com.example.filesystem.service;

import com.example.filesystem.pojo.bo.FindOwnFileBo;
import com.example.filesystem.pojo.vo.ResponseVo;

public interface FileService {
    ResponseVo findOwnFile(FindOwnFileBo findOwnFileBo);
}
