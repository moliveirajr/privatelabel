package br.com.legus.privatelabel.controller;

import br.com.legus.privatelabel.entity.AccessTokenEntity;
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
    public ResponseEntity<AccessTokenEntity> getAccessToken() {
        try {
            return ResponseEntity.ok().body(accessTokenService.AcessToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
