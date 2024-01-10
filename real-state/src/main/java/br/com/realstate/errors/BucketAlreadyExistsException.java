package br.com.realstate.errors;

public class BucketAlreadyExistsException extends Exception {

    public BucketAlreadyExistsException(String bucketName) {
        super(String.format("Bucket %s already exists", bucketName));
    }
}
