package br.com.legus.privatelabel;

import br.com.legus.privatelabel.entity.ParceriaEntity;
import br.com.legus.privatelabel.repository.ParceriaRepository;
import br.com.legus.privatelabel.service.bradesco.BradescoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ParceriaRepositoryTeste {

    @Autowired
    private ParceriaRepository parceriaRepository;

    @Test
    public void testeFilial1000(){
        ParceriaEntity parceriaEntity = parceriaRepository.findByFilial (1000L);
        assertNotNull(parceriaEntity);


        assertEquals("API acessada com sucesso!", "API acessada com sucesso!");

    }
}
