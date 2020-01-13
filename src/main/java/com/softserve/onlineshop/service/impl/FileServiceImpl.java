package com.softserve.onlineshop.service.impl;

import com.softserve.onlineshop.service.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

import static com.softserve.onlineshop.constant.Parameters.IMG_DIR;

public class FileServiceImpl implements FileService {

    public String saveFile(String request) {
        createDir(IMG_DIR);

        String[] data = request.split(",");
        String metaInfo = data[0];
        String base64File = data[1];

        String fileName = createFileName(getFileExtensionFromMetaInfo(metaInfo));

        try {
            Files.write(
                    Paths.get(IMG_DIR, fileName),
                    Base64.getDecoder().decode(base64File.getBytes())
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    private String createFileName(String fileExtension) {
        String fileName = UUID.randomUUID().toString();
        return String.format("%s.%s", fileName, fileExtension);
    }

    private String getFileExtensionFromMetaInfo(String metaInfo) {
        return metaInfo.split("/")[1].split(";")[0];
    }

    private void createDir(String dir) {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
