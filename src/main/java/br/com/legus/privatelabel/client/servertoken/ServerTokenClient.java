package br.com.legus.privatelabel.client.servertoken;

import br.com.legus.privatelabel.entity.ServerToken;
//import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "serverToken")
public interface ServerTokenClient {

//    @RequestLine("GET /api/v1/access-token")
    @RequestMapping(method = RequestMethod.GET, value ="/api/v1/access-token" )
    ServerToken getTokenMarco();

    @RequestMapping(method = RequestMethod.POST, value = "/auth/server/v1.1/token", consumes = "application/x-www-form-urlencoded")
//    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,value = "/auth/server/v1.1/token",produces = "application/json")
//    @RequestLine("POST /auth/server/v1.1/token")
//    @Headers({"Content-Type:application/x-www-form-urlencoded"})
    ServerTokenResponse getServerToken(ServerTokenRequest request);
}
