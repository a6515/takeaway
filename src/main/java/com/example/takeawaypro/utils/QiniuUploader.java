package com.example.takeawaypro.utils;

import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.alibaba.fastjson.JSONObject;

public class QiniuUploader {
    // 七牛云配置
    private static final String ACCESS_KEY = "q933uqPAeEHz3kUZ8VkDnnbngC-fmpGqppiaI3HF";
    private static final String SECRET_KEY = "ohfY5s-2agI1c9wQmdXlTByyBdezIlQDfB-Am1tS";
    private static final String BUCKET = "abc66";

    public static String Qiniuup(String path) {
        // 配置七牛云存储区域
        Configuration cfg = new Configuration(Region.region2()); // 根据你的实际情况选择存储区域

        // 实例化一个上传的工具类
        UploadManager uploadManager = new UploadManager(cfg);

        // 生成上传凭证，过期时间为3600秒
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET, null, 3600, null);

        // 要上传的文件路径
        String localFilePath = path;

        try {
            // 调用put方法上传
            Response response = uploadManager.put(localFilePath, null, upToken);

            // 打印返回的信息
            String responseBody = response.bodyString();
            System.out.println(responseBody);

            // 解析返回的JSON
            JSONObject jsonObject = JSONObject.parseObject(responseBody);
            String key = jsonObject.getString("key");

            // 构建访问图片的地址
            String imageUrl = "http://sf218l20c.hn-bkt.clouddn.com/" + key;
            System.out.println("图片的地址为"+imageUrl);

            return imageUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
