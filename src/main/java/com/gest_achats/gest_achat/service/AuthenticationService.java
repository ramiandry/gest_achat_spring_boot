package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.config.JwtService;
import com.gest_achats.gest_achat.dto.UtilisateurDto;
import com.gest_achats.gest_achat.model.Utilisateur;
import com.gest_achats.gest_achat.repository.AdminRepository;
import com.gest_achats.gest_achat.repository.DepartementRepository;
import com.gest_achats.gest_achat.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.gest_achats.gest_achat.controller.AuthenticationResponse;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private  UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

     @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private JwtService jwtService;
    public AuthenticationResponse register(UtilisateurDto utilisateur) {
        System.out.println(utilisateur.getUserMdp());
        var user=Utilisateur.builder()
                .avatar(utilisateur.getUserAvatar())
                .email(utilisateur.getUserEmail())
                .nom_utilisateur(utilisateur.getUserUsername())
                .tel(utilisateur.getUserTel())
                .admin(this.adminRepository.findById(utilisateur.getId_admin()).get())
                .mot_de_passe(passwordEncoder.encode(utilisateur.getUserMdp()))
                .departement(this.departementRepository.findById(utilisateur.getId_departement()).get())
                .build();
        utilisateurRepository.save(user);
        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse login(Utilisateur utilisateur) {
        //System.out.println(utilisateur.getUsername()+" "+ utilisateur.getPassword());
        String mdp=utilisateur.getMot_de_passe();
        var user=utilisateurRepository.findByEmail(utilisateur.getUsername())
                .orElseThrow();
        if(passwordEncoder.matches(utilisateur.getPassword(), user.getMot_de_passe())){
            var jwtToken= jwtService.generateToken(user);
            return AuthenticationResponse.builder().token(jwtToken).id(user.getId()).build();
        }else {
            return null;
        }

    }
}
