package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServerToken {
    private String accessToken;
    private String tokenType;
    private Long expiresIn;
    private String scope;
}
