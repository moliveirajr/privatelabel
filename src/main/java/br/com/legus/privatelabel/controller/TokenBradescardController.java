package br.com.legus.privatelabel.controller;

import br.com.legus.privatelabel.entity.ServerToken;
import br.com.legus.privatelabel.service.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TokenBradescardController {

    @Autowired
    private AccessTokenService accessTokenService;

    @ResponseBody
    @GetMapping("/api/v1/access-token")
    public ResponseEntity<ServerToken> getAccessToken() {

        try {
            return ResponseEntity.ok().body(accessTokenService.AccessToken ());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
