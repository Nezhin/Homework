package data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    private String username;


    public FileManager(String username) throws IOException {
        this.username = username;
        Files.createDirectory(Paths.get("/" + username + "/"));
    }

    public void uploadFile(String fileName, byte[] bytes) {
        try (FileOutputStream fos = new FileOutputStream("/" + username + "/" + fileName)) {
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
