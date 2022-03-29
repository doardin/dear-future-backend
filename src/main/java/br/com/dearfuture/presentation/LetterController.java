package br.com.dearfuture.presentation;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dearfuture.application.letter.dto.PostCreateLetterDto;
import br.com.dearfuture.application.letter.service.LetterAppService;
import lombok.RequiredArgsConstructor;

@RestController
@Validated
@RequiredArgsConstructor
public class LetterController {
    
    private final LetterAppService letterAppService;

    @PostMapping("/letter/compose")
    public ResponseEntity<Void> postCreateLetter(@RequestBody @Valid PostCreateLetterDto postCreateLetterDto){
        this.letterAppService.postCreateLetter(postCreateLetterDto);
        return ResponseEntity.ok().build();
    }

}
