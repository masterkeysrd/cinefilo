package com.lextersoft.cinefilo.model.service;

import com.lextersoft.cinefilo.model.objets.PosterImage;
import com.lextersoft.cinefilo.model.repository.StorageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class StorageService implements StorageRepository {

    @Override
    public PosterImage savePosterImage(MultipartFile file, String baseUrl) {
        File uploads = savePath(file.getOriginalFilename());

        try {
            try (InputStream input = file.getInputStream()) {
                Files.copy(input, uploads.toPath());
            }
            return new PosterImage(uploads.getName(), baseUrl + "/" + uploads.getName(), uploads.getTotalSpace());
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Bad Image");
        }
    }

    @Override
    public byte[] getImage(String imageName) {
        File file = new File(System.getProperty("jboss.server.data.dir"), "IMG\\" + imageName);
        try {
            return Files.readAllBytes(file.toPath());
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private File savePath(String fileName) {
        return new File(System.getProperty("jboss.server.data.dir"), "IMG\\IMG" + new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date()) + fileName);
    }
}
