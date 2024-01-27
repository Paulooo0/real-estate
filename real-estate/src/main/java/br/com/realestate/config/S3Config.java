package br.com.realestate.config;

import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public abstract class S3Config {
    Dotenv dotenv = Dotenv.configure().load();
    String accessKey = dotenv.get("AWS_ACCESS_KEY");
    String secretKey = dotenv.get("AWS_SECRET_KEY");
    
    public String imagesBucket = dotenv.get("S3_IMAGES_BUCKET");

    AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

    public final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
    .withRegion(Regions.SA_EAST_1)
    .withCredentials(new AWSStaticCredentialsProvider(credentials))
    .build();
}


