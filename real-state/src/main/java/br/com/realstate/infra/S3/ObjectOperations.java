package br.com.realstate.infra.S3;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import br.com.realstate.config.S3Config;

public class ObjectOperations extends S3Config {
    @Value("${AWS_ACCESS_KEY}")
    private String accessKey;

    @Value("${AWS_SECRET_KEY}")
    private String secretKey;

    @Value("${IMAGES_BUCKET}")
    private String imagesBucket;

    private final AmazonS3 s3;

    public ObjectOperations() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        s3 = AmazonS3ClientBuilder.standard()
        .withRegion(Regions.SA_EAST_1)
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .build();
    }

    public List<String> ListObjects() {
        ListObjectsV2Result result = s3.listObjectsV2(imagesBucket);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        return objects.stream().map(S3ObjectSummary::getKey).toList();
    }

    public void deleteObject(String key) {
        if (!s3.doesObjectExist(imagesBucket, key)) {
            return;
        }
        s3.deleteObject(imagesBucket, key);
    }

    public void sendObject(String key, String content) {
        s3.putObject(imagesBucket, key, content);
    }
}