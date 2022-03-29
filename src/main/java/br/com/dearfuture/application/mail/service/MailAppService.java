package br.com.dearfuture.application.mail.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.dearfuture.application.mail.dto.SendMailDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailAppService {
    
    private final JavaMailSender javaMailSender;

    public void sendMail(SendMailDto sendMailDto){
        SimpleMailMessage msg = new SimpleMailMessage();
        
        msg.setTo(sendMailDto.getRecipients());
        msg.setSubject(sendMailDto.getSubject());
        msg.setText(sendMailDto.getText());

        javaMailSender.send(msg);
    }

}
