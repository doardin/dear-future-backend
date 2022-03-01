package br.com.dearfuture.application.user.dto;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;

import br.com.dearfuture.annotations.groups.GV0001;
import br.com.dearfuture.annotations.groups.GV0002;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@GroupSequence({PostUserAuthenticationDto.class, GV0001.class, GV0002.class})
public class PostUserAuthenticationDto {

    @NotBlank(message = "Este campo é obrigatório", groups = { GV0001.class })
    private String alias;

    @NotBlank(message = "Este campo é obrigatório", groups = { GV0002.class })
    private String password;
}
