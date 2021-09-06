package br.com.legus.privatelabel.service.bradesco;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class BradescoRequest {

    public static HttpEntity getRequest(String endpoint, String metodo, String parametros, String body) {

        Long nonce = System.currentTimeMillis ( );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd'T'HH:mm:ss'-03:00'");
        String timeStamp = ZonedDateTime.now (ZoneId.systemDefault ( )).format (formatter);
        String strAccessToken = TokenBradescard.strAccessToken ( );

        StringBuilder payload = new StringBuilder ( );
        payload.append (metodo).append ("\n")
                .append (endpoint).append ("\n")
                .append (parametros).append ("\n")
                .append (body.toString ( )).append ("\n")
                .append (strAccessToken).append ("\n")
                .append (nonce).append ("\n")
                .append (timeStamp).append ("\n")
                .append ("SHA256");

        HttpHeaders headers = new HttpHeaders ( );
        headers.add ("Authorization", "Bearer " + strAccessToken);
        headers.add ("X-Brad-Signature", BradescardSignure.bradescardSign (payload.toString ( )));
        headers.add ("X-Brad-Nonce", String.valueOf (nonce));
        headers.add ("X-Brad-timestamp", timeStamp);
        headers.add ("X-Brad-Algorithm", "SHA256");

        HttpEntity<String> request = new HttpEntity<> (body, headers);

        return request;
    }

}
