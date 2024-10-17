package org.example.CommonHelpers;

import com.google.cloud.storage.*;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class ImageHelper {
    public static final String DevStorageBucket = "ultimate-company.appspot.com";
    public static final String CurrentEnvironment = "Dev";

    public static void saveBase64ToFirebase(String serviceAccountKeyDirectory, String base64String, String fileName, long carrierId) throws IOException {
        // Initialize Firebase
        if(!StringUtils.hasText(base64String)) {
            return;
        }

        FileInputStream serviceAccount = new FileInputStream(Path.of(serviceAccountKeyDirectory, "ultimate-company-firebase-adminsdk-jfu71-a9038ba014.json").toString());
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket(DevStorageBucket)
                .build();
        if(FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }

        // Decode Base64 string to binary data
        byte[] data = Base64.getDecoder().decode(base64String);

        // Construct the path in Firebase Storage
        String path = CurrentEnvironment + "/" + carrierId  + "/" + fileName;

        // Create BlobId and BlobInfo
        BlobId blobId = BlobId.of(DevStorageBucket, path);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

        // Upload the file
        Storage storage = StorageOptions.getDefaultInstance().getService();
        storage.create(blobInfo, data);
    }

    public static void deleteFileFromFirebase(String serviceAccountKeyDirectory, String fileName, long carrierId) throws IOException {
        // Initialize Firebase
        if(!StringUtils.hasText(fileName)) {
            return;
        }

        FileInputStream serviceAccount = new FileInputStream(Path.of(serviceAccountKeyDirectory, "ultimate-company-firebase-adminsdk-jfu71-a9038ba014.json").toString());
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket(DevStorageBucket)
                .build();
        if(FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }

        // Construct the path in Firebase Storage
        String path = CurrentEnvironment + "/" + carrierId  + "/" + fileName;

        // Create BlobId
        BlobId blobId = BlobId.of(DevStorageBucket, path);

        // Get a reference to the Storage service
        Storage storage = StorageOptions.getDefaultInstance().getService();

        // Delete the file
        storage.delete(blobId);
    }

    public static String getBase64FromFirebase(String serviceAccountKeyDirectory, String fileName, long carrierId) throws IOException {
        if(!StringUtils.hasText(fileName)) {
            return null;
        }

        FileInputStream serviceAccount = new FileInputStream(Path.of(serviceAccountKeyDirectory, "ultimate-company-firebase-adminsdk-jfu71-a9038ba014.json").toString());
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket(DevStorageBucket)
                .build();
        if(FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }

        String path = CurrentEnvironment + "/" + carrierId  + "/" + fileName;

        BlobId blobId = BlobId.of(DevStorageBucket, path);
        Storage storage = StorageOptions.getDefaultInstance().getService();

        Blob blob = storage.get(blobId);

        if (blob != null) {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                blob.downloadTo(outputStream);
                byte[] data = outputStream.toByteArray();
                return Base64.getEncoder().encodeToString(data);
            }
            catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
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

    public static String getBase64FromByteArray(byte[] image) {
        if (image == null || image.length == 0) {
            return null;
        }

        // Encode the byte array to Base64
        String base64String = Base64.getEncoder().encodeToString(image);

        // Return the Base64 string with a data URL prefix for PNG images
        return "data:image/png;base64," + base64String;
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
