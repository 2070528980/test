package com.example.shiro.common.utils;


import io.minio.MinioClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public class MinioUtil {



    private final static Logger logger = LoggerFactory.getLogger(MinioUtil.class);

    private static String url = "http://139.155.82.188:9000";  //minio服务的IP端口
    private static String accessKey = "admin";
    private static String secretKey = "adminadmin";

    /**
     * 删除文件
     * @param bucketName 桶名称
     * @param fileName 文件名称
     */
    public static boolean deleteFile(String bucketName,String fileName) {

        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            minioClient.removeObject(bucketName, fileName);
            return true;
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }
    }

    /**
     * 上传文件
     * @param file 需要上传的文件
     * @param bucketName 桶名称
     * @return 上传成功的文件路径
     */
    public static String uploadFile(MultipartFile file, String fileName, String bucketName) {

        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            if(checkBucket(minioClient,bucketName)){
                InputStream is= file.getInputStream(); //得到文件流
//                String fileName = file.getOriginalFilename(); //文件名
                String contentType = file.getContentType();  //类型
                minioClient.putObject(bucketName,fileName,is,contentType); //把文件放置Minio桶(文件夹)
                return minioClient.getObjectUrl(bucketName, fileName);
            }else {
                return null;
            }
        } catch (Exception e) {
            logger.error("", e);
            return null;
        }
    }

    /**
     * 检查桶是否存在，不存在就创建
     */
    private static boolean checkBucket(MinioClient minioClient, String bucketName){
        try {
            if(minioClient.bucketExists(bucketName)) {
                logger.info("已存在桶");
            }else {
                minioClient.makeBucket(bucketName);
                logger.info("成功创建桶");
            }
            return true;
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }

    }




}
