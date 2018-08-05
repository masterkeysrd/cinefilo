package com.lextersoft.cinefilo.controller;

import com.lextersoft.cinefilo.model.objets.PosterImage;
import com.lextersoft.cinefilo.model.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/image/upload")
public class UploadController {

    @Autowired
    StorageRepository storageRepository;

    @PostMapping(value = "/poster-image")
    public PosterImage uploadPoster (@RequestParam("image") MultipartFile image, HttpServletRequest request) {
        return storageRepository.savePosterImage(image, request.getRequestURL().toString());
    }

    @GetMapping("poster-image/{image}")
    public byte[] getImage(@PathVariable(name = "image") String image) {
        return storageRepository.getImage(image + ".jpg");
    }
}
