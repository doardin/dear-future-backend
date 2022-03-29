package br.com.dearfuture.application.letter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostCreateLetterDto {
    private String subject;
    private String text;
    private String deliveryIn;
    private String[] recipients;
}
