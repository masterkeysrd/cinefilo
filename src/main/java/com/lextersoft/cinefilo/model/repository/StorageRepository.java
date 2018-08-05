package com.lextersoft.cinefilo.model.repository;

import com.lextersoft.cinefilo.model.objets.PosterImage;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageRepository {
    PosterImage savePosterImage(MultipartFile file, String baseUrl);
    byte[] getImage(String imageName);
}
