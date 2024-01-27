package br.com.realestate.infra.S3;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import br.com.realestate.config.S3Config;
import br.com.realestate.errors.BucketAlreadyExistsException;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BucketOperations extends S3Config {
    public Bucket getBucket(String bucket_name) {
        Bucket named_bucket = null;
        List<Bucket> buckets = s3.listBuckets();
        for (Bucket b : buckets) {
            if (b.getName().equals(bucket_name)) {
                named_bucket = b;
            }
        }
        return named_bucket;
    }

    public Bucket createBucket(String bucket_name) throws BucketAlreadyExistsException {
        Bucket b = null;
        if (s3.doesBucketExistV2(bucket_name)) {
            throw new BucketAlreadyExistsException(bucket_name);
        } else {
            try {
                b = s3.createBucket(bucket_name);
            } catch (AmazonS3Exception e) {
                System.err.println(e.getErrorMessage());
            }
        }
        return b;
    }

    public void listBuckets() {
        List<Bucket> buckets = s3.listBuckets();
        for (Bucket b : buckets) {
            System.out.println(b.getName());
        }
    }

    public void deleteBucket(String bucket_name) {
        ObjectListing object_listing = s3.listObjects(bucket_name);
        while (true) {
            for (Iterator<?> iterator =
                object_listing.getObjectSummaries().iterator();
                iterator.hasNext(); ) {
                S3ObjectSummary summary = (S3ObjectSummary) iterator.next();
                s3.deleteObject(bucket_name, summary.getKey());
            }

            // more object_listing to retrieve?
            if (object_listing.isTruncated()) {
                object_listing = s3.listNextBatchOfObjects(object_listing);
            } else {
                break;
            }
        }

        s3.deleteBucket(bucket_name);
    }
}
