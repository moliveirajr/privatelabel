package br.com.legus.privatelabel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenEntity {
    private String access_token;
    private String token_type;
    private String expires_in;
    private String scope;
}
