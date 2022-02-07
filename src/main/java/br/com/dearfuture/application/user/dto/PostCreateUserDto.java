package br.com.dearfuture.application.user.dto;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.dearfuture.annotations.birthdate.BirthDateSubset;
import br.com.dearfuture.annotations.fieldmatch.FieldMatchSubset;
import br.com.dearfuture.annotations.groups.GV0001;
import br.com.dearfuture.annotations.groups.GV0002;
import br.com.dearfuture.annotations.groups.GV0003;
import br.com.dearfuture.annotations.groups.GV0004;
import br.com.dearfuture.annotations.groups.GV0005;
import br.com.dearfuture.annotations.groups.GV0006;
import br.com.dearfuture.annotations.groups.GV0007;
import br.com.dearfuture.annotations.uniqueemail.UniqueEmailSubset;
import br.com.dearfuture.annotations.uniqueusername.UniqueUsernameSubset;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldMatchSubset(first = "password", second = "passwordConfirmation", message = "O campo de confirmação de senha deve ser igual ao campo senha", groups = { GV0007.class })
@GroupSequence({PostCreateUserDto.class, GV0001.class, GV0002.class, GV0003.class, GV0004.class, GV0005.class, GV0006.class, GV0007.class})
public class PostCreateUserDto {

    @NotBlank(message = "Este campo é obrigatório", groups = { GV0001.class })
    private String name;

    @NotNull(message = "Este campo é obrigatório", groups = { GV0002.class })
    @BirthDateSubset(groups = { GV0002.class })
    private String birthDate;

    @NotBlank(message = "Este campo é obrigatório", groups = { GV0003.class })
    @UniqueUsernameSubset(groups = { GV0003.class })
    private String username;

    @NotBlank(message = "Este campo é obrigatório",groups = { GV0004.class })
    @UniqueEmailSubset(groups = { GV0004.class })
    private String email;

    @NotBlank(message = "Este campo é obrigatório", groups = { GV0005.class })
    private String password;

    @NotBlank(message = "Este campo é obrigatório", groups = { GV0006.class })
    private String passwordConfirmation;
}
