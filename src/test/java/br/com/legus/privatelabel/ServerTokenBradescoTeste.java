package br.com.legus.privatelabel;

import br.com.legus.privatelabel.service.bradesco.BradescoRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServerTokenBradescoTeste {

    private final String baseURL = "https://proxy.api.prebanco.com.br";

    @Test
    public void testeDeEmpacotamento() {
        String endpoint = "/v1.1/jwt-service";
        ObjectMapper mapper = new ObjectMapper ( );
        ObjectNode testeNode = mapper.createObjectNode ( );
        testeNode.put ("teste", "valor");

        String retorno = new RestTemplate ( )
                .postForObject (baseURL + endpoint,
                        BradescoRequest.getRequest (endpoint, "POST", "", testeNode.toString ( )),
                        String.class);

        assertEquals ("API acessada com sucesso!", retorno);
    }

    @Test
    public void testeDeEmpacotamentoComClasse() {
        String endpoint = "/v1.1/jwt-service";
        TesteValue testeValue = new TesteValue ( );

        ObjectMapper mapper = new ObjectMapper ( );
        String body = "";

        try {
            body = mapper.writeValueAsString (testeValue);
            log.info (body);
        } catch (JsonProcessingException e) {
            e.printStackTrace ( );
        }
        String urlFull = baseURL + endpoint;
        log.info (urlFull);

        String retorno = new RestTemplate ( )
                .postForObject (urlFull,
                        BradescoRequest.getRequest (endpoint, "POST", "", body), String.class);

        log.info (retorno);

        assertEquals ("API acessada com sucesso!", "API acessada com sucesso!");
    }
}

class TesteValue {
    private final String teste;

    public TesteValue() {
        this.teste = "valor";
    }
}
