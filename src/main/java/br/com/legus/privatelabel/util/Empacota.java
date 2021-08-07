package br.com.legus.privatelabel.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class Empacota {

    @Value("${bradescard.base.url}")
    private String baseURL;

    public static void getPayload(String endpoint, String metodo, String parametros, String body) {

        Long nonce = System.currentTimeMillis();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu.MM.dd HH:mm:ss");
        String timeStamp = ZonedDateTime.now(ZoneId.systemDefault()).format(formatter);

        StringBuilder payload = new StringBuilder();
        payload.append(metodo).append("\n")
                .append(endpoint).append("\n")
                .append(parametros).append("\n")
                .append("\n");

        log.info(String.valueOf(payload));
    }
}
