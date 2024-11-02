package com.gest_achats.gest_achat.service;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
public interface FileStorageService {
    String uploadImage(String path, MultipartFile file) throws IOException;
    InputStream getResource(String path, String filename) throws FileNotFoundException;



}
