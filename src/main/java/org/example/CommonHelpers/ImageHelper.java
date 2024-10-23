package org.example.CommonHelpers;

import com.box.sdk.*;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class ImageHelper {
    // Box operations
    public static String getFileFromBox(String folderName, String fileName, String boxDeveloperToken) throws Exception {
        BoxAPIConnection api = new BoxAPIConnection(boxDeveloperToken);

        // Get the folder from Box
        String folderId = "";
        BoxFolder rootFolder = BoxFolder.getRootFolder(api);
        for (BoxItem.Info itemInfo : rootFolder.getChildren()) {
            if(itemInfo.getName().equalsIgnoreCase(folderName)){
                folderId = itemInfo.getID();
                break;
            }
        }

        BoxFolder folder = new BoxFolder(api, folderId);
        // Iterate through items in the folder to find the file
        for (BoxItem.Info itemInfo : folder) {
            if (itemInfo instanceof BoxFile.Info && itemInfo.getName().equals(fileName)) {
                BoxFile file = (BoxFile) itemInfo.getResource();
                return file.getID();
            }
        }

        throw new Exception("File not found in the folder.");
    }

    public static byte[] downloadImageFromBox(String fileId, String boxDeveloperToken) throws IOException {
        BoxAPIConnection api = new BoxAPIConnection(boxDeveloperToken);
        BoxFile file = new BoxFile(api, fileId);

        // Create a ByteArrayOutputStream to capture the image data
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Download the image directly to the ByteArrayOutputStream
        file.download(outputStream);

        // Convert the output stream to a byte array
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
