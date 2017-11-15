package com.devopsbuddy.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.devopsbuddy.backend.persistence.repositories")
@EntityScan(basePackages = "com.devopsbuddy.backend.persistence.domain.backend")
@EnableTransactionManagement
@PropertySource("file:///Users/richard/study/github/devopsbuddy/src/main/resources/config/application-common.properties")
public class ApplicationConfig {

    @Value("${aws.s3.profile}")
    private String awsProfileName;

    @Value("${aws.s3.accesskey}")
    private String awsPAccessKey;

    @Value("${aws.s3.secretkey}")
    private String awsSecretKey;


    @Bean
    public AmazonS3 s3Client() {
        BasicAWSCredentials creds = new BasicAWSCredentials(awsPAccessKey, awsSecretKey);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(
                new AWSStaticCredentialsProvider(creds)).withRegion(Regions.US_WEST_2).build();


        return s3Client;
    }


}
