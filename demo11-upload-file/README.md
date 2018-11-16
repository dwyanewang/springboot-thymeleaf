### **一、单个文件上传**

##### 1、上传至项目中的resources/static/images/upload/中

    File path = new File(StringUtils.substringBefore(uploadDir, "/target"));
    File upload = new File(path.getAbsolutePath(), "/src/main/resources/static/images/upload/");
##### 2、上传至项目的target文件夹下的classes/static/images/upload/文件夹中

    File path = new File(uploadDir);
    File upload = new File(path.getAbsolutePath(), "/static/images/upload/");
##### 3、打jar包时，上传至jar文件同目录下/static/images/upload/中

    File upload = new File("/static/images/upload/");
    
### **二、多个文件上传**
##### 注意：在控制层中接受前台传递来的文件集合时，需在`MultipartFile[] files`前加上`@RequestParam`，否则会接收不到前台传递过来的文件集合