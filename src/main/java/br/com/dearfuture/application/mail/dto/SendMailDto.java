package br.com.dearfuture.application.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SendMailDto {

    private String text;
    private String subject;
    private String[] recipients;
}
