package br.com.legus.privatelabel.controller;

import br.com.legus.privatelabel.service.PrivateKeyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PrivateKeyController {

    @Autowired
    private PrivateKeyService privateKeyService;

    @ResponseBody
    @GetMapping("/api/v1/tokenserver")
    public String getTokenServer() {
        try {
            return privateKeyService.getPrivateKey();
        } catch (Exception e) {
            return "Erro na criação da chave";
        }
    }


}
