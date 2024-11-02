package com.gest_achats.gest_achat.service;



import com.gest_achats.gest_achat.dto.ReceptionnisteDto;
import com.gest_achats.gest_achat.model.Receptionniste;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ReceptionnisteService {
    List<ReceptionnisteDto> getAll();
    ResponseEntity<ReceptionnisteDto> create(Receptionniste receptionniste, MultipartFile signature);
    public ResponseEntity<Receptionniste> edit(Receptionniste receptionniste, Long id);
    public String delete(Long id);
    public ReceptionnisteDto convertToEntite(Receptionniste receptionniste);
    public byte[] show(Long id) throws IOException;
}
