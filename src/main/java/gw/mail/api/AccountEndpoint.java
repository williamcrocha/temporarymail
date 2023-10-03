package gw.mail.temporarymail.api;

import gw.mail.temporarymail.domain.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "account",url = "https://api.mail.gw/accounts")
public interface AccountEndpoint {

    @PostMapping
    Account createAccount(@RequestBody Account account);

    @GetMapping(value = "/{id}")
    Account getAccount(@RequestHeader(value = "Authorization",required = true) String authorization, @PathVariable("id")String id);

}
