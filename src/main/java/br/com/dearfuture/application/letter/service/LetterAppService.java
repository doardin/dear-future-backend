package br.com.dearfuture.application.letter.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.dearfuture.application.general.dto.ResponseCredentialsDto;
import br.com.dearfuture.application.letter.dto.PostCreateLetterDto;
import br.com.dearfuture.domain.letter.entity.Letter;
import br.com.dearfuture.domain.letter.repository.LetterRepository;
import br.com.dearfuture.domain.mail.entity.Mail;
import br.com.dearfuture.domain.user.entity.User;
import br.com.dearfuture.domain.user.repository.UserRepository;
import br.com.dearfuture.exceptions.UserNotFoundException;
import br.com.dearfuture.utils.HeadersUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LetterAppService {
    private final LetterRepository letterRepository;
    private final UserRepository userRepository;

    public void postCreateLetter(PostCreateLetterDto postCreateLetterDto){
        ResponseCredentialsDto credentialsDto = HeadersUtil.decodeJwt();
        User user = this.userRepository.getUserById(credentialsDto.getUserId()).orElseThrow(UserNotFoundException::new);
        
        Letter letter = Letter.builder()
            .id(UUID.randomUUID().toString())
            .subject(postCreateLetterDto.getSubject())
            .text(postCreateLetterDto.getText())
            .deliveryIn(LocalDate.parse(postCreateLetterDto.getDeliveryIn()))
            .user(user)
            .recipients(new LinkedList<Mail>()).build();

        for(String recipient : postCreateLetterDto.getRecipients()){
            Mail mail = Mail.builder()
                .id(UUID.randomUUID().toString())
                .address(recipient).build();
            letter.getRecipients().add(mail);
        }
        
        this.letterRepository.save(letter);
    }
}
