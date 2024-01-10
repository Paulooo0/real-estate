package br.com.realstate.config;

import org.springframework.beans.factory.annotation.Value;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public abstract class S3Config {
    @Value("${AWS_ACCESS_KEY}")
    public String accessKey;

    @Value("${AWS_SECRET_KEY}")
    public String secretKey;

    public final AmazonS3 s3;

    public S3Config() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        s3 = AmazonS3ClientBuilder.standard()
        .withRegion(Regions.SA_EAST_1)
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .build();
    }
}
