package com.gest_achats.gest_achat.service;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //File name
        String name=file.getOriginalFilename();

        //random name generate file
        String randomID= UUID.randomUUID().toString();
        String fileName1=randomID.concat(name.substring(name.lastIndexOf(".")));

        //Fullpath
        String filePath=path+File.separator+fileName1;

        //file
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName1;
    }

    @Override
    public InputStream getResource(String path, String filename) throws FileNotFoundException {
        String fullpath=path+ File.separator+filename;
        InputStream is=new FileInputStream(fullpath);
        return is ;
    }
}
