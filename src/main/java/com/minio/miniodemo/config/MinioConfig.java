package com.minio.miniodemo.config;

import com.minio.miniodemo.utils.MinioUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    /**
     * url
     */
    @Value(value = "${spring.minio.url}")
    private String minioUrl;

    /**
     * username
     */
    @Value(value = "${spring.minio.access-key}")
    private String minioName;

    /**
     * password
     */
    @Value(value = "${spring.minio.secret-key}")
    private String minioPass;

    @Value(value = "${spring.minio.bucket}")
    private String bucketName;

    @Bean
    public void initMinio(){
        MinioUtils.setMinioUrl(minioUrl);
        MinioUtils.setMinioName(minioName);
        MinioUtils.setMinioPass(minioPass);
        MinioUtils.setBucketName(bucketName);
    }
}
