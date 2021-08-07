package br.com.legus.privatelabel;

import br.com.legus.privatelabel.util.Empacota;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpacotaTeste {

    @Test
    public void testeDeEmpacotamento(){

        Empacota.getPayload("/v1.1/jwt-service","POST","", "{\"teste\":\"valor\"}");

    }
}
