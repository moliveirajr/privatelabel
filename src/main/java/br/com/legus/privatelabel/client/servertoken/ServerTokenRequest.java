package br.com.legus.privatelabel.client.servertoken;

import com.fasterxml.jackson.annotation.JsonProperty;
import feign.form.FormProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServerTokenRequest {

    @FormProperty ("grant_type")
    private String grantType = "urn:ietf:params:oauth:grant-type:jwt-bearer";
    private String assertion;

    public ServerTokenRequest (String assertion) {
        this.assertion = assertion;
    }
}
