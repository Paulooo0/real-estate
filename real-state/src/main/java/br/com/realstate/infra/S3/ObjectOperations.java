package br.com.realstate.infra.S3;

import java.util.List;

import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import br.com.realstate.config.S3Config;

public class ObjectOperations extends S3Config {
    public List<String> ListObjects(String bucketName) {
        ListObjectsV2Result result = s3.listObjectsV2(bucketName);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        return objects.stream().map(S3ObjectSummary::getKey).toList();
    }

    public void deleteObject(String bucketName, String key) {
        if (!s3.doesObjectExist(bucketName, key)) {
            return;
        }
        s3.deleteObject(bucketName, key);
    }

    public void sendObject(String bucketName, String key, String content) {
        s3.putObject(bucketName, key, content);
    }
}