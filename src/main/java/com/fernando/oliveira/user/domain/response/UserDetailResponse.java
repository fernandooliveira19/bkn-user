package com.fernando.oliveira.user.domain.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailResponse implements Serializable {
    private String name;
    private String email;
}
