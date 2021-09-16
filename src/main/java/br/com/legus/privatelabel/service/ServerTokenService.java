package br.com.legus.privatelabel.service;

import br.com.legus.privatelabel.client.servertoken.ServerTokenClient;
import br.com.legus.privatelabel.client.servertoken.ServerTokenGateway;
import br.com.legus.privatelabel.client.servertoken.ServerTokenRequest;
import br.com.legus.privatelabel.entity.ServerToken;
import br.com.legus.privatelabel.service.bradesco.BradescardSignure;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.slf4j.Slf4jLogger;
import io.jsonwebtoken.Jwts;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
//@Scope("singleton")
public class ServerTokenService {
    // TODO: 07/09/2021 Modificar para properties
    String url = "https://proxy.api.prebanco.com.br";
    String clientId = "8ff166a4-2547-4398-84ed-83a52aa5e676";

    public ServerToken serverToken;

    public ServerToken getTokenMarco() {
        ServerTokenClient serverTokenClient = Feign.builder ( )
                .decoder (new GsonDecoder ( ))
                .logger(new Slf4jLogger (ServerTokenClient.class))
                .logLevel(Logger.Level.FULL)
                .target (ServerTokenClient.class, "https://viaprivatelabel.herokuapp.com/");
        return serverTokenClient.getTokenMarco ( );
    }

    private String geraAssertion() {
        Map<String, Object> mapHeader = new HashMap<> ( );
        mapHeader.put ("alg", "HS256");
        mapHeader.put ("typ", "JWT");

        Map<String, Object> mapClaims = new HashMap<> ( );
        mapClaims.put ("aud", url);
        mapClaims.put ("sub", clientId);
        mapClaims.put ("iat", String.valueOf (System.currentTimeMillis ( ) / 1_000));
        mapClaims.put ("exp", String.valueOf ((System.currentTimeMillis ( ) / 1_000) + 2_592_000));
        mapClaims.put ("jti", String.valueOf (System.currentTimeMillis ( )));
        mapClaims.put ("ver", "1.1");

        String assertion = Jwts.builder ( )
                .setHeader (mapHeader)
                .setClaims (mapClaims)
                .signWith (BradescardSignure.bradescardPrivateKey ( )).compact ( );

        return assertion;
    }

    public void getServerToken() {
        ServerTokenRequest serverTokenRequest = new ServerTokenRequest (geraAssertion ());
        serverToken = ServerTokenGateway.getServerToken (serverTokenRequest);
    }
}
