package br.com.legus.privatelabel.service;

import br.com.legus.privatelabel.entity.ServerToken;
import br.com.legus.privatelabel.service.bradesco.ServerTokenBradesco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccessTokenService {

    public void getServerToken (){
        ServerToken serverToken = new ServerTokenBradesco ().getAccessToken();

    }

    public ServerToken AccessToken() {
        return new ServerTokenBradesco ().getAccessToken();
    }
}
