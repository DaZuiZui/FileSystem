package com.example.filesystem.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Api(value = "文件板块接口",tags = {"文件板块接口"})
@RestController
@RequestMapping("/file")
public class FileController {
}
