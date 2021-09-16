package br.com.legus.privatelabel.client.servertoken;

import br.com.legus.privatelabel.entity.ServerToken;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerTokenResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expiresIn")
    private Long expiresIn;

    @JsonProperty("scope")
    private String scope;

    public ServerToken convert (){
        ServerToken serverToken = ServerToken.builder ( )
                .accessToken (accessToken)
                .tokenType (tokenType)
                .expiresIn (expiresIn)
                .scope (scope).build ();
        return serverToken;
    }
}
