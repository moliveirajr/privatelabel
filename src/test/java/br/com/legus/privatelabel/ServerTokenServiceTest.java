package br.com.legus.privatelabel;

import br.com.legus.privatelabel.service.ServerTokenService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServerTokenServiceTest {

    @Autowired
    ServerTokenService service;

    @Test
    public void tokenMarcoTest() {

        System.out.println (service.getTokenMarco ().toString () );

        assertEquals("API acessada com sucesso!", "API acessada com sucesso!");
    }

    @Test
    public void tokenBradescoTest() {

        service.getServerToken ();

        System.out.println (service.serverToken.toString ());

        assertEquals("API acessada com sucesso!", "API acessada com sucesso!");
    }

}
