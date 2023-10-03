package gw.mail.temporarymail.api;

import gw.mail.temporarymail.domain.Account;
import gw.mail.temporarymail.domain.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "token",url = "https://api.mail.gw/token")
public interface TokenEndpoint {

    @PostMapping
    Token getToken(@RequestBody Account account);

}
