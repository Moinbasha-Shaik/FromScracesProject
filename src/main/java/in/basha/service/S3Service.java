package in.basha.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

   
    private String bucketName=System.getenv("aws.s3.bucket");

  
    private String accessKey=System.getenv("aws.access.Key");

   
    private String secretKey=System.getenv("aws.secret.Key");

   
    private String region="eu-north-1";

    private S3Client s3Client;

    public void init() {
        AwsCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        s3Client = S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(() -> credentials)
                .build();

        System.out.println("S3 client object initialised");
    }

    public String uploadFile(MultipartFile file, String fileName) throws Exception {
    	init();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType(file.getContentType())
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

        return "https://" + bucketName + ".s3." + region + ".amazonaws.com/" + fileName;
    }
}
