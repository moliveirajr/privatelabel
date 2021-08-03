package br.com.legus.privatelabel.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AccessTokenService {

    private String privateKey = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDgtZ+AeFbb78N6\n" +
            "ZaxJO2A6yaM7bpRAo1qm0YwvA5OsUoBt9fK0JaJP7qyTs8mqg9RradhXINH+Z+xF\n" +
            "IUSBemzlICETeVs66WyOlet8I2Cv7VISmTex4gSB42atFbV4PPOfL8hERyC2IFWw\n" +
            "PGi6kjvNyvVrComonC9TnNRv4PFabSoe2Xgcvs6WE8yV1O/7H1bWvPyZPu28EIdH\n" +
            "viVxDuEf8kGc843pyAYsa5cO5HbEyEDs8PGqoer0t8jYL7TUzEAYrqYLqqPh60ga\n" +
            "orLfJjIBvcX30G53+pROxjNpARTsV69+r8eobDhPEmrt4PJ3tAJSxnYscuAzZfTX\n" +
            "e9PsOPNRAgMBAAECggEBAJCdMn5adAPtZQ9jWaJznPWYiP2Zp72Fo7SSTTaAhcwz\n" +
            "+EVMMJsxUSlCADy6SwH6/3z1TG6eR6cDuLGwvEbbxDMdH0xKIKVkTiHhaACnP/VY\n" +
            "tSYVBxvqyl3RPGYN/5DXIS6EcM1IPUwYuSzHY9sWe3hwssrlqDwj7+1OlAVAbfNz\n" +
            "8x1WaXOQodhl2IRtuL3FSCQDQfaGrcLCBXseElWOKiYL1XYSqg7Uk1zGAzDYXZe8\n" +
            "Zke/iaP6Lg73xBFYNlI8Z5t554S3bWHOmJtB9JgxF06FpubNLgDhL7UgHhHvRJTz\n" +
            "tTgYuRgfi4ichvwFVp8sw80dZEQWt+QszCAbFRJuWLUCgYEA8KM00YNJ5om49a1T\n" +
            "q4N3unHuHu/cbp2IUDbpRKpgLL9RWDrNjH3kWd58avU5at+MANrpuFuuwCnXKqZU\n" +
            "Rk/MryVHGR5WPXr0gYwAIEvS3c23DPM2RMl5sNLfGG+OeOAcYZn/Zus9iJGzCBPF\n" +
            "BdPyXnxhudsDiz7Y7rD2LUdgIVMCgYEA7w4Z0I8jQs7ElFvbfF8+D2G1ytESAto8\n" +
            "1BfSCOFvOU08cY6Hb1cHuDeQt2l03bRpO3/DP1UbCE9TEsMKrISz2q+Mdcq1bEOa\n" +
            "LjKODtnSB691hyDyb1+Ekb+B9ygzQeTQQ8nchwVxn/CAxx0E370QhXvdBZUAnxQe\n" +
            "/c4nFBneEEsCgYEAojcy/OWHJMzEjYD5PU6ToHD694n0S/EQGhraJzq/OIsD9/kz\n" +
            "5ThcfiSYNLX4rc3ioBTypx/O7qWF8a9MclWLAqqbghhMRIelWcsZrqvOi00Iz8cI\n" +
            "V1iGGygb0mopXdyd5UGdxTBhO7YUPSauk14sLXulmVdFzVFhhY5vdVh/OhcCgYBL\n" +
            "gJ2gpITThfDKltSUzJQSUZ8URsI0im8p4bghu+ngJEfR6d1WyhsTEOGxPCqAF4oh\n" +
            "E7I8H4ohLsSjKV0GrgcMK+PmFDcG0bcxniAGCr/uU3mAS2SmznlVezH2OQkvZ7Br\n" +
            "qKbxMkP36wMRYFX4wIMmVb+yEqSWmclMCj+HdsAPTwKBgQDSjZG66BZzWIfuwvUF\n" +
            "F6G9k20XIPqX/6m6ut4pFLwBZtTZImdwoIj+NUKswluFS74lm4y3mifMLIyEI6lq\n" +
            "unwRU2SQt+U/6V/C33tt2CrsmRbwSaPhRu+BYtyTt7zVXP+7mPOvUm63uqpTpF8I\n" +
            "I5+v7O0zlrOcNWTMhiFLlbYqYQ==\n" +
            "-----END PRIVATE KEY-----\n";

    private static RSAPrivateKey getPrivateKeyFromString(String key) throws IOException, GeneralSecurityException {
        String privateKeyPEM = key;
        privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----\n", "");
        privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");
        byte[] encoded = Base64.decodeBase64(privateKeyPEM);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);

        return (RSAPrivateKey) kf.generatePrivate(keySpec);
    }

    public String getToken() {

        RSAPrivateKey keyBradesco = null;
        try {
            keyBradesco = getPrivateKeyFromString(privateKey);
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }

        Map<String, Object> mapHeader = new HashMap<>();
        mapHeader.put("alg","HS256");
        mapHeader.put("typ","JWT");

        Map<String, Object> mapClaims = new HashMap<>();
        mapClaims.put("aud","https://proxy.api.prebanco.com.br/auth/server/v1.1/token");
        mapClaims.put("sub","8ff166a4-2547-4398-84ed-83a52aa5e676");
        mapClaims.put("iat",String.valueOf(System.currentTimeMillis() / 1_000));
        mapClaims.put("exp",String.valueOf((System.currentTimeMillis() / 1_000) + 2_592_000));
        mapClaims.put("jti",String.valueOf(System.currentTimeMillis()));
        mapClaims.put("ver","1.1");

        return Jwts.builder()
                .setHeader(mapHeader)
                .setClaims(mapClaims)
                .signWith(keyBradesco).compact();
    }

    public ResponseEntity<String> getAccessToken() {

        String uri = "https://proxy.api.prebanco.com.br/auth/server/v1.1/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer");
        map.add("assertion",getToken());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        return new RestTemplate().postForEntity(uri, request , String.class);
    }

}
