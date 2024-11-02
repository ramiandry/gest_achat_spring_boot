package com.gest_achats.gest_achat.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import com.gest_achats.gest_achat.model.FileStorage;
import com.gest_achats.gest_achat.service.FileStorageService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


@Controller
@CrossOrigin("http://localhost:3000")
@RequestMapping("/file")
public class FileStorageController {

    @Autowired
    FileStorageService storageService;

    @Value("${project.image}")
    private  String path;
    @PostMapping(value="/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file){
        String fileName =file.getOriginalFilename();

        try {
            fileName=this.storageService.uploadImage(path, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

    //method serve files
    @GetMapping(value="/{filename}")
    public void downloadImage(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException {
        InputStream resource=this.storageService.getResource(path, filename);
        response.setContentType(String.valueOf(MediaType.valueOf("application/pdf")));
        StreamUtils.copy(resource,response.getOutputStream());
    }

}
