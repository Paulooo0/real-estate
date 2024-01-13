package br.com.realestate.errors;

public class BucketAlreadyExistsException extends Exception {

    public BucketAlreadyExistsException(String bucketName) {
        super(String.format("Bucket %s already exists", bucketName));
    }
}
