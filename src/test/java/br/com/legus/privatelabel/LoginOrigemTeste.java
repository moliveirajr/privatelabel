package br.com.legus.privatelabel;

import br.com.legus.privatelabel.entity.UsuarioEntity;
import br.com.legus.privatelabel.service.bradesco.BradescoRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoginOrigemTeste {

    private String baseURL = "https://proxy.api.prebanco.com.br";

    @Test
    public void loginOrigemTeste (){
        String  baseURL = "https://proxy.api.prebanco.com.br";
        String endpoint = "/cartoes/aquisicao/parceiros/v1/login/origem";

        UsuarioEntity usuarioEntity = new UsuarioEntity ( "C05066794", 536,145,1,12101);
        usuarioEntity.getInfo ().getDispositivo ().setDeviceId ("string");
        usuarioEntity.getInfo ().getDispositivo ().setFabricante ("string");
        usuarioEntity.getInfo ().getDispositivo ().setLatitude ("string");
        usuarioEntity.getInfo ().getDispositivo ().setLongitude ("string");
        usuarioEntity.getInfo ().getDispositivo ().setModelo ("string");
        usuarioEntity.getInfo ().getDispositivo ().setPlataforma ("string");
        usuarioEntity.getInfo ().getDispositivo ().setTipoDispositivo ("string");

        usuarioEntity.getInfo ().getNavegador ().setFingerprint ("string");
        usuarioEntity.getInfo ().getNavegador ().setNome ("string");
        usuarioEntity.getInfo ().getNavegador ().setVersao ("string");

        usuarioEntity.getInfo ().getRede ().setIp ("string");
        usuarioEntity.getInfo ().getRede ().setTipoConexao ("string");
        usuarioEntity.getInfo ().getRede ().setWifiSSID ("string");

        usuarioEntity.getInfo ().getSo ().setIdioma ("string");
        usuarioEntity.getInfo ().getSo ().setResolucao ("string");
        usuarioEntity.getInfo ().getSo ().setSo ("string");
        usuarioEntity.getInfo ().getSo ().setVersao ("string");

        log.info (usuarioEntity.toString ());


        ObjectMapper mapper = new ObjectMapper();
        String body = "";
        try {
            body = mapper.writeValueAsString (usuarioEntity);
            log.info (body);
        } catch (JsonProcessingException e) {
            e.printStackTrace ( );
        }
        String urlFull = baseURL + endpoint;
        log.info (urlFull);

        String retorno = new RestTemplate ( )
                .postForObject (urlFull,
                        BradescoRequest.getRequest (endpoint,"POST","",body),String.class);

        log.info (retorno);
    }

}
