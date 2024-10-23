package org.example.CommonHelpers;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.util.StringUtils;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class ImageHelper {
    static {
        try {
            if(FirebaseApp.getApps() == null || FirebaseApp.getApps().isEmpty()) {
                FileInputStream serviceAccount = new FileInputStream("src/main/resources/ultimate-company-firebase-adminsdk-jfu71-2edaaefa96.json");
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setStorageBucket("ultimate-company.appspot.com")
                        .build();
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Firebase operations
    public static byte[] downloadFileAsBytesFromFirebase(String filePath) throws IOException {
        // Get a reference to the Firebase storage bucket
        Bucket bucket = StorageClient.getInstance().bucket();

        // Get the file (blob) from Firebase Storage
        Blob blob = bucket.get(filePath);

        // Download the file into a byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blob.downloadTo(outputStream);

        return outputStream.toByteArray();
    }


    public static String saveBase64ToFile(String base64String, String directory) throws IOException {
        if(!StringUtils.hasText(base64String)) {
            return null;
        }

        // Decode the Base64 string to a byte array
        String sanitizedBase64String = base64String.replaceFirst("^data:image/[^;]+;base64,", "");
        byte[] fileBytes = Base64.getDecoder().decode(sanitizedBase64String);

        // Create the directory if it doesn't exist
        File dir = new File(directory).getAbsoluteFile();
        if (!dir.exists()) {
            return null;
        }

        // generate a random uuid
        String uuid = UUID.randomUUID().toString();

        // Get the current timestamp
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

        // Create a file object for the file to be created
        String fileName = uuid + "_" + timestamp + ".png";
        File file = new File(dir, fileName);

        // Write the byte array to the file
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(fileBytes);
        }

        return fileName;
    }

    public static Pair<String, byte[]> getImage(String imageDirectory, String imageName) throws IOException{
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            byte[] imageBytes = Files.readAllBytes(imagePath);
            String contentType = switch (imageName.substring(imageName.lastIndexOf('.')).toLowerCase()) {
                case ".jpg" -> "image/jpeg";
                case ".png" -> "image/png";
                case ".bmp" -> "image/bmp";
                case ".gif" -> "image/gif";
                default -> "application/octet-stream";
            };

            return Pair.of(contentType, imageBytes);
        } else {
            return null;
        }
    }

    public static boolean deleteImage(String directory, String imageName) {
        if(!StringUtils.hasText(imageName)) {
            return false;
        }

        // Create a File object for the file to be deleted
        File file = new File(directory, imageName).getAbsoluteFile();

        // Check if the file exists
        if (!file.exists()) {
            return false;
        }

        // Attempt to delete the file
        return file.delete();
    }

    public static String getBase64FromImage(String imageDirectory, String imageName) throws IOException {
        if(!StringUtils.hasText(imageName)) {
            return null;
        }

        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            byte[] imageBytes = Files.readAllBytes(imagePath);

            // Get the image's MIME type
            String contentType = switch (imageName.substring(imageName.lastIndexOf('.')).toLowerCase()) {
                case ".jpg" -> "image/jpeg";
                case ".png" -> "image/png";
                case ".bmp" -> "image/bmp";
                case ".gif" -> "image/gif";
                default -> "application/octet-stream";
            };

            // Encode the byte array to Base64
            String base64String = Base64.getEncoder().encodeToString(imageBytes);

            // Return the Base64 string with data URL prefix
            return String.format("data:%s;base64,%s", contentType, base64String);
        } else {
            return null;
        }
    }

    public static byte[] getByteArrayFromBase64ImageString(String base64Image) {
        if (!StringUtils.hasText(base64Image)) {
            return null;
        }

        // Remove the data URL prefix if it exists
        String sanitizedBase64String = base64Image.replaceFirst("^data:image/[^;]+;base64,", "");

        // Decode the Base64 string to a byte array
        return Base64.getDecoder().decode(sanitizedBase64String);
    }
}
