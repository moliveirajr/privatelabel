package br.com.legus.privatelabel;

import br.com.legus.privatelabel.entity.UsuarioEntity;
import br.com.legus.privatelabel.service.bradesco.BradescardSignure;
import br.com.legus.privatelabel.service.bradesco.ServerTokenBradesco;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoginOrigemTeste {

    private final String baseURL = "https://proxy.api.prebanco.com.br";

    @Test
    public void loginOrigemTeste() {
        String baseURL = "https://proxy.api.prebanco.com.br";
        String endpoint = "/cartoes/aquisicao/parceiros/v1/login/origem";

        UsuarioEntity usuarioEntity = new UsuarioEntity ("C05066794", 536, 145, 1, 12101);
        log.info (usuarioEntity.toString ( ));

        ObjectWriter ow = new ObjectMapper ( ).writer ( );
        String json = null;
        try {
            json = ow.writeValueAsString (usuarioEntity);
        } catch (JsonProcessingException e) {
            e.printStackTrace ( );
        }
        log.info (json);

        Long nonce = System.currentTimeMillis ( );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd'T'HH:mm:ss'-03:00'");
        String timeStamp = ZonedDateTime.now (ZoneId.systemDefault ( )).format (formatter);
        String strAccessToken = ServerTokenBradesco.strAccessToken ( );

        StringBuilder payload = new StringBuilder ( );
        payload.append ("POST").append ("\n")
                .append (endpoint).append ("\n").append ("\n")
                .append (json).append ("\n")
                .append (strAccessToken).append ("\n")
                .append (nonce).append ("\n")
                .append (timeStamp).append ("\n")
                .append ("SHA256");
        log.info (payload.toString ( ));

        HttpHeaders headers = new HttpHeaders ( );
        headers.add ("Content-Type", "application/json");
        headers.add ("Authorization", "Bearer " + strAccessToken);
        headers.add ("X-Brad-Signature", BradescardSignure.bradescardSign (payload.toString ( )));
        headers.add ("X-Brad-Nonce", String.valueOf (nonce));
        headers.add ("X-Brad-timestamp", timeStamp);
        headers.add ("X-Brad-Algorithm", "SHA256");
        headers.add ("access-token", "8ff166a4-2547-4398-84ed-83a52aa5e676");
        System.out.println (String.valueOf (headers.get ("X-Brad-Signature")).replace ("[", "").replace ("]", ""));
        log.info (headers.toString ( ));

        HttpEntity<String> request = new HttpEntity<> (json, headers);

        String retorno = new RestTemplate ( )
                .postForObject (baseURL + endpoint, request, String.class);
        log.info (retorno);
    }

    @Test
    public void loginOperadorTeste() {
        String baseURL = "https://proxy.api.prebanco.com.br";
        String endpoint = "/cartoes/aquisicao/parceiros/v1/login/sgi";

        UsuarioEntity usuarioEntity = new UsuarioEntity ("B7700WAP", 536, 145, 1, 12101);
        log.info (usuarioEntity.toString ( ));


        ObjectMapper mapper = new ObjectMapper ( );
        ObjectNode json = mapper.createObjectNode ( );
        json.pojoNode (usuarioEntity);
        json.put ("senha", "Batata12");
        log.info (json.toString ( ));

        Long nonce = System.currentTimeMillis ( );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyy-MM-dd'T'HH:mm:ss'-03:00'");
        String timeStamp = ZonedDateTime.now (ZoneId.systemDefault ( )).format (formatter);
        String strAccessToken = ServerTokenBradesco.strAccessToken ( );

        StringBuilder payload = new StringBuilder ( );
        payload.append ("POST").append ("\n")
                .append (endpoint).append ("\n").append ("\n")
                .append (json).append ("\n")
                .append (strAccessToken).append ("\n")
                .append (nonce).append ("\n")
                .append (timeStamp).append ("\n")
                .append ("SHA256");
        log.info (payload.toString ( ));

        HttpHeaders headers = new HttpHeaders ( );
        headers.add ("Authorization", "Bearer " + strAccessToken);
        headers.add ("X-Brad-Signature", BradescardSignure.bradescardSign (payload.toString ( )));
        headers.add ("X-Brad-Nonce", String.valueOf (nonce));
        headers.add ("X-Brad-timestamp", timeStamp);
        headers.add ("X-Brad-Algorithm", "SHA256");
        headers.add ("access-token", "8ff166a4-2547-4398-84ed-83a52aa5e676");
        System.out.println (String.valueOf (headers.get ("X-Brad-Signature")).replace ("[", "").replace ("]", ""));
        log.info (String.valueOf (headers.get ("X-Brad-Signature")));
        log.info (headers.toString ( ));

        HttpEntity<String> request = new HttpEntity<> (json.toString ( ), headers);

        String retorno = new RestTemplate ( )
                .postForObject (baseURL + endpoint, request, String.class);
        log.info (retorno);
    }

}
