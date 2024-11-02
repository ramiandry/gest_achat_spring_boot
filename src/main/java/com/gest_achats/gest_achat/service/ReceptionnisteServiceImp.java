package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.ReceptionnisteDto;
import com.gest_achats.gest_achat.model.Receptionniste;
import com.gest_achats.gest_achat.repository.ReceptionnisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceptionnisteServiceImp implements ReceptionnisteService{

    @Autowired
    private FileStorageService storageService;
    @Value("${project.image}")
    private  String path;
    @Autowired
    private ReceptionnisteRepository receptionnisteRepository;


    @Override
    public List<ReceptionnisteDto> getAll() {
       return this.receptionnisteRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ReceptionnisteDto> create(Receptionniste receptionniste, MultipartFile signature) {
        try {
            receptionniste.setSignature(this.storageService.uploadImage(path, signature));
            this.receptionnisteRepository.save(receptionniste);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.receptionnisteRepository.findById(receptionniste.getId()).map(this::convertToEntite).get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ResponseEntity<Receptionniste> edit(Receptionniste receptionniste, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        this.receptionnisteRepository.deleteById(id);
        return "delete";
    }

    @Override
    public ReceptionnisteDto convertToEntite(Receptionniste receptionniste) {
        ReceptionnisteDto receptionnisteDto=new ReceptionnisteDto();
        receptionnisteDto.setId(receptionniste.getId());
        receptionnisteDto.setEmail(receptionniste.getEmail());
        receptionnisteDto.setTel(receptionniste.getTel());
        receptionnisteDto.setNom(receptionniste.getNom());
        receptionnisteDto.setSignature(receptionniste.getSignature());
        return receptionnisteDto;
    }

    @Override
    public byte[] show(Long id) throws IOException {
        Optional<Receptionniste> receptionniste=this.receptionnisteRepository.findById(id);
        byte[] images= Files.readAllBytes(new File(path+"/"+receptionniste.get().getSignature()).toPath());
        return images;
    }
}
