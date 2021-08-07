package br.com.legus.privatelabel.service;

import br.com.legus.privatelabel.entity.AccessTokenEntity;
import br.com.legus.privatelabel.util.TokenBradescard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccessTokenService {

    public AccessTokenEntity AcessToken() {
        return new TokenBradescard().getAccessToken();
    }
}
