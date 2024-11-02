package com.gest_achats.gest_achat.service;

import com.gest_achats.gest_achat.model.CommandeArticle;
import com.gest_achats.gest_achat.repository.CommandeArticleRepository;
import com.gest_achats.gest_achat.repository.CommandeRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private CommandeArticleRepository commandeArticleRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    public String sendEmail(String to, Long id_commande){
        /*SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);*/
        List<CommandeArticle> commandeArticleList=this.commandeArticleRepository.findByCommande(this.commandeRepository.findById(id_commande).get());

        MimeMessage message =javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setTo(to);
            helper.setSubject("Commande de CEM");
            String messages="<img src='cid:logo' alt='logo' width='250px'/><br>";
            messages+="<h3>Bonjour, nous avons une commande pour vous</h3><br>";
            messages+="<strong style='margin:10px 0'>Voici la listes de commande</strong>";
            messages+="<table style='border:1px solid black; width:300px'><tr><th>Nom d'article</th><th>Nombre de commande<th/></tr>";

            for (CommandeArticle commandeArticle: commandeArticleList) {
                messages+="<tr><td style='border:1px solid black;'>"+commandeArticle.getArticle().getDescription()+"</td><td style='text-align:center; border:1px solid black;'>"+commandeArticle.getQuantite_commande()+"</td></tr>";
            }
            messages+="</table>";

            messages+="<p style='margin-top:30px;'>Cordialement</p>";
            helper.setText(messages, true);
            ClassPathResource imageResource=new ClassPathResource("static/cem-logo.png");
            helper.addInline("logo",imageResource);
            javaMailSender.send(message);
            return "email envoyé avec succes!";
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        //return message.getTo()+" "+message.getText()+" "+message.getSubject();
    }
}
