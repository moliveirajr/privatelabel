package br.com.legus.privatelabel.client.servertoken;

import br.com.legus.privatelabel.entity.ServerToken;
import feign.Feign;
import feign.Logger;
import feign.form.FormEncoder;
import feign.form.spring.SpringFormEncoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

public class ServerTokenGateway {

    public static ServerToken getServerToken(ServerTokenRequest request) {
        ServerTokenClient serverTokenClient = Feign.builder ( )
                .decoder (new GsonDecoder ( ))
                .encoder (new SpringFormEncoder ())
                .contract (new SpringMvcContract (  ))
                .logger (new Slf4jLogger ( ServerTokenClient.class))
                .logLevel (Logger.Level.FULL)
                // TODO: 16/09/2021 Mudar para properties
                .target (ServerTokenClient.class, "https://proxy.api.prebanco.com.br");

        System.out.println (serverTokenClient.toString ());
        System.out.println (request.toString () );

        return serverTokenClient.getServerToken ( request ).convert ( );
    }
}
