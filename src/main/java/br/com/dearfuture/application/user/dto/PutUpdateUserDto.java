package br.com.dearfuture.application.user.dto;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.dearfuture.annotations.birthdate.BirthDateSubset;
import br.com.dearfuture.annotations.groups.GV0001;
import br.com.dearfuture.annotations.groups.GV0002;
import br.com.dearfuture.annotations.groups.GV0003;
import br.com.dearfuture.annotations.groups.GV0004;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@GroupSequence({PutUpdateUserDto.class, GV0001.class, GV0002.class, GV0003.class, GV0004.class})
public class PutUpdateUserDto {
    @NotBlank(message = "Este campo é obrigatório", groups = { GV0001.class })
    private String name;

    @NotNull(message = "Este campo é obrigatório", groups = { GV0002.class })
    @BirthDateSubset(groups = { GV0002.class })
    private String birthDate;

    @NotBlank(message = "Este campo é obrigatório", groups = { GV0003.class })
    private String username;

    @NotBlank(message = "Este campo é obrigatório",groups = { GV0004.class })
    private String email;

}
