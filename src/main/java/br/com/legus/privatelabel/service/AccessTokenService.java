package br.com.legus.privatelabel.service;

import br.com.legus.privatelabel.entity.ServerToken;
import br.com.legus.privatelabel.service.bradesco.TokenBradescard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccessTokenService {

    public ServerToken AcessToken() {
        return new TokenBradescard().getAccessToken();
    }
}
