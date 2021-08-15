package br.com.legus.privatelabel.service.bradesco;

import br.com.legus.privatelabel.entity.AccessTokenEntity;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class TokenBradescard {

    private static final String baseURL = "https://proxy.api.prebanco.com.br/";

    public static AccessTokenEntity getAccessToken() {
        String uri = baseURL + "/auth/server/v1.1/token";

        Map<String, Object> mapHeader = new HashMap<>();
        mapHeader.put("alg", "HS256");
        mapHeader.put("typ", "JWT");

        Map<String, Object> mapClaims = new HashMap<>();
        mapClaims.put("aud", baseURL + "/auth/server/v1.1/token");
        mapClaims.put("sub", "8ff166a4-2547-4398-84ed-83a52aa5e676");
        mapClaims.put("iat", String.valueOf(System.currentTimeMillis() / 1_000));
        mapClaims.put("exp", String.valueOf((System.currentTimeMillis() / 1_000) + 2_592_000));
        mapClaims.put("jti", String.valueOf(System.currentTimeMillis()));
        mapClaims.put("ver", "1.1");

        String jwts = Jwts.builder()
                .setHeader(mapHeader)
                .setClaims(mapClaims)
                .signWith(BradescardSignure.bradescardPrivateKey ()).compact();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer");
        map.add("assertion", jwts);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        return new RestTemplate().postForObject(uri, request, AccessTokenEntity.class);
    }

    public static String strAccessToken() {

        AccessTokenEntity accessTokenEntity = getAccessToken();
        return accessTokenEntity.getAccess_token();
    }

}
