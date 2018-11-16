package com.dwyanewang.controller;

import org.springframework.util.ResourceUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
public class UploadController {
    @GetMapping("/upload/test")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    /**
     * 提取上传方法为公共方法
     *
     * @param uploadDir 上传文件目录
     * @param file      上传对象
     * @throws Exception 抛出异常
     */
    private void excuteUpload(String uploadDir, MultipartFile file) throws Exception {
        String originalName = file.getOriginalFilename();
        System.out.println(originalName);
        assert originalName != null;
        if (!originalName.equals("")) {
            //服务器端保存的文件对象
            File serverFile = new File(uploadDir + "/" + originalName);
            //将上传的文件写到服务器端文件内
            file.transferTo(serverFile);
        }
    }

    /**
     * 上传单个文件
     *
     * @param request 请求对象
     * @param file    前台上传的文件对象
     * @return String 上传情况（成功或失败）
     */
    @PostMapping("/upload")
    public String upload(HttpServletRequest request, MultipartFile file) {
        try {
            //获取项目路径
            String uploadDir = ResourceUtils.getURL("classpath:").getPath();
            //1、上传至项目中的resources/static/images/upload/中
            File path = new File(StringUtils.substringBefore(uploadDir, "/target"));
            File upload = new File(path.getAbsolutePath(), "/src/main/resources/static/images/upload/");
//            //2、上传至项目的target文件夹下的classes/static/images/upload/文件夹中
//            File path = new File(uploadDir);
//            File upload = new File(path.getAbsolutePath(), "/static/images/upload/");
//            //3、打jar包时，上传至jar文件同目录下/static/images/upload/中
//            File upload = new File("/static/images/upload/");
            //如果目录不存在，自动创建文件夹
            if (!upload.exists()) upload.mkdirs();
            System.out.println("upload url:" + upload.getAbsolutePath());
            //调用上传方法
            excuteUpload(upload.getAbsolutePath(), file);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    /**
     * 上传多个文件
     *
     * @param request 请求对象
     * @param files   前台上传的文件集合
     * @return String 上传情况（成功或失败）
     */
    @PostMapping("/uploads")
    public String uploads(HttpServletRequest request, @RequestParam("file") MultipartFile[] files) {
        try {
            //获取项目路径
            String uploadDir = ResourceUtils.getURL("classpath:").getPath();
            //1、上传至项目中的resources/static/images/upload/中
            File filePath = new File(StringUtils.substringBefore(uploadDir, "/target"));
            File upload = new File(filePath.getAbsolutePath(), "/src/main/resources/static/upload/");
            //如果目录不存在，自动创建文件夹
            if (!upload.exists()) upload.mkdir();
            System.out.println("upload url:" + upload.getAbsolutePath());
            for (MultipartFile file : files) {
                //调用上传方法
                excuteUpload(upload.getAbsolutePath(), file);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }


}
