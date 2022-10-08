package com.fernando.oliveira.user.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CreateUserRequest implements Serializable {

    @ApiModelProperty(name="email", value="Email do usuario", example="nome.usuario@teste.com", required = true)
    @Email(message = "Email inválido")
    private String email;

    @ApiModelProperty(name="password", value="Senha do usuário", example="Senha forte", required = true)
    @NotNull(message = "Senha é obrigatório")
    private String password;
}
