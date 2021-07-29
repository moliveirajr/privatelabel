package br.com.legus.privatelabel.controller;

import br.com.legus.privatelabel.service.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PrivateKeyController {

    @Autowired
    private AccessTokenService accessTokenService;

    @GetMapping("/api/v1/string-access-token")
    public ResponseEntity<?> getAccessToken() {
        return accessTokenService.getAccessToken();
    }

}
