package br.com.legus.privatelabel;

import br.com.legus.privatelabel.service.bradesco.BradescoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TokenBradescardTeste {
    @Autowired
    @Value("${bradescard.base.url}")
    private String baseURL;

    @Test
    public void testeDeEmpacotamento(){

        String endpoint = "/v1.1/jwt-service";
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode testeNode = mapper.createObjectNode();
        testeNode.put("teste","valor");

        String retorno = new RestTemplate ( )
                .postForObject (baseURL + endpoint,
                BradescoRequest.getRequest (endpoint,"POST","",testeNode),
                String.class);

        assertEquals("API acessada com sucesso!", retorno);

    }
}
