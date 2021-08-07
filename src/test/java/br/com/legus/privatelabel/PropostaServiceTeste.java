package br.com.legus.privatelabel;

import br.com.legus.privatelabel.service.PropostaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropostaServiceTeste {

    @Autowired
    private PropostaService propostaService;

    @Test
    public void testLoginOrigem (){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode testeNode = mapper.createObjectNode();

        testeNode = propostaService.loginOrigem();
        assertNotNull(testeNode);

    }
}
