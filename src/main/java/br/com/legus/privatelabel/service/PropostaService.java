package br.com.legus.privatelabel.service;

import br.com.legus.privatelabel.entity.AccessTokenEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PropostaService {

    @Autowired
    private AccessTokenService accessTokenService;


    public ObjectNode loginOrigem() {

        AccessTokenEntity accessTokenEntity = null;
//        accessTokenEntity = accessTokenService.getAccessToken();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootLogin = mapper.createObjectNode();
        rootLogin.put("usuario", "123456789");
        rootLogin.put("canal", 536);
        rootLogin.put("origem", 145);
        rootLogin.put("tipoPontoVenda", 1);
        rootLogin.put("numeroPontoVenda", 12101);

        ObjectNode dispositivo = mapper.createObjectNode();
        dispositivo.put("deviceId", "string");
        dispositivo.put("fabricante", "string");
        dispositivo.put("latitude", "string");
        dispositivo.put("longitude", "string");
        dispositivo.put("modelo", "string");
        dispositivo.put("plataforma", "string");
        dispositivo.put("root", true);
        dispositivo.put("tipoDispositivo", "string");
        dispositivo.put("virtual", true);

        ObjectNode navegador = mapper.createObjectNode();
        navegador.put("fingerprint", "string");
        navegador.put("nome", "string");
        navegador.put("versao", "string");

        ObjectNode rede = mapper.createObjectNode();
        rede.put("ip", "string");
        rede.put("tipoConexao", "string");
        rede.put("wifiSSID", "string");

        ObjectNode so = mapper.createObjectNode();
        so.put("idioma", "string");
        so.put("resolucao", "string");
        so.put("so", "string");
        so.put("versao", "string");

        ObjectNode info = mapper.createObjectNode();
        info.set("dispositivo", dispositivo);
        info.set("navegador", navegador);
        info.set("rede", rede);
        info.set("so", so);

        rootLogin.set("Info", info);

        log.info(rootLogin.toString());


        String uri = "https://proxy.api.prebanco.com.br/cartoes/aquisicao/parceiros/v1/login/origem";

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Brad-Auth", "Bearer " + accessTokenEntity.getAccess_token());
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


        HttpEntity<String> request = new HttpEntity<String>(rootLogin.toString(), headers);

        String tokenResult = "";
        try {
            tokenResult = new RestTemplate().postForObject(uri, request, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

        //JsonNode root = objectMapper.readTree(personResultAsJsonStr);

        log.info(tokenResult);

        return rootLogin;
    }
}
