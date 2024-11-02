package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.dto.UtilisateurDto;
import com.gest_achats.gest_achat.model.Admin;
import com.gest_achats.gest_achat.model.Departement;
import com.gest_achats.gest_achat.model.Utilisateur;
import com.gest_achats.gest_achat.repository.AdminRepository;
import com.gest_achats.gest_achat.repository.DepartementRepository;
import com.gest_achats.gest_achat.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImp implements UtilisateurService{

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private FileStorageService storageService;

    @Value("${project.image}")
    private  String path;

    @Override
    public List<UtilisateurDto> get() {
        return this.utilisateurRepository.findAll().stream().map(this::convertToEntite).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<UtilisateurDto> create(MultipartFile avatar, String nom_utilisateur, String email, String tel, String mdp, long role, long departementId) {
        Optional<Admin> admin = this.adminRepository.findById(role);
        Optional<Departement> departement=this.departementRepository.findById(departementId);
        Utilisateur utilisateur= null;
        try {
            utilisateur = new Utilisateur(null, this.storageService.uploadImage(path, avatar), nom_utilisateur, email,tel,passwordEncoder.encode(mdp), false,admin.get(),departement.get(),null,null, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.utilisateurRepository.save(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.utilisateurRepository.findById(utilisateur.getId()).map(this::convertToEntite).get());
    }

    @Override
    public ResponseEntity<UtilisateurDto> edit(Long id, MultipartFile avatar, String nom_utilisateur, String email, String tel, String mdp, long role, long departementId) {
        Utilisateur utilisateur= this.utilisateurRepository.findById(id).get();
        if(role>0){
            utilisateur.setAdmin(this.adminRepository.findById(role).get());
        }
       if(departementId>0){
           utilisateur.setDepartement(this.departementRepository.findById(departementId).get());
       }
       if(!avatar.isEmpty()){
           try {
               utilisateur.setAvatar(this.storageService.uploadImage(path, avatar));
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }
       if(!mdp.isEmpty()){
           utilisateur.setMot_de_passe(passwordEncoder.encode(mdp));
       }
        utilisateur.setNom_utilisateur(nom_utilisateur);
       utilisateur.setEmail(email);
       utilisateur.setTel(tel);
        this.utilisateurRepository.save(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.utilisateurRepository.findById(utilisateur.getId()).map(this::convertToEntite).get());
    }


    @Override
    public ResponseEntity<UtilisateurDto> editStatus(Long id) {
        Utilisateur utilisateur=this.utilisateurRepository.findById(id).get();
        utilisateur.setValide(!utilisateur.getValide());
        this.utilisateurRepository.save(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.utilisateurRepository.findById(utilisateur.getId()).map(this::convertToEntite).get());
    }

    @Override
    public String delete(Long id) {
        this.utilisateurRepository.deleteById(id);
        return "delete succesfully !!";
    }

    @Override
    public byte[] show(Long id) throws IOException {
        Optional<Utilisateur> utilisateur=this.utilisateurRepository.findById(id);
        byte[] images= Files.readAllBytes(new File(path+"/"+utilisateur.get().getAvatar()).toPath());
        return images;
    }

    @Override
    public UtilisateurDto getOne(Long id) {
        return (UtilisateurDto) this.utilisateurRepository.findById(id).map(this::convertToEntite).get();
    }

    @Override
    public UtilisateurDto convertToEntite(Utilisateur utilisateur) {
       UtilisateurDto utilisateurDto=new UtilisateurDto();
       utilisateurDto.setUserId(utilisateur.getId());
       utilisateurDto.setUserAvatar(utilisateur.getAvatar());
       utilisateurDto.setUserUsername(utilisateur.getNom_utilisateur());
       utilisateurDto.setUserMdp(utilisateur.getMot_de_passe());
       utilisateurDto.setUserEmail(utilisateur.getEmail());
       utilisateurDto.setUserTel(utilisateur.getTel());
       utilisateurDto.setUserValide(utilisateur.getValide());
       utilisateurDto.setType(utilisateur.getAdmin().getType());
       utilisateurDto.setDepartement(utilisateur.getDepartement().getDepartement());
       utilisateurDto.setId_admin(utilisateur.getAdmin().getId());
       utilisateurDto.setId_departement(utilisateur.getDepartement().getId());
       utilisateurDto.setId_role(utilisateur.getAdmin().getId());
       return  utilisateurDto;
    }
}
