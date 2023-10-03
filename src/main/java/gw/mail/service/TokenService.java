package gw.mail.temporarymail.service;

import gw.mail.temporarymail.api.TokenEndpoint;
import gw.mail.temporarymail.domain.Account;
import gw.mail.temporarymail.domain.Token;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class TokenService {

    private final TokenEndpoint tokenEndpoint;

    public Token getToken(Account account){
        log.info("Getting account token {}",account);
        Token token = tokenEndpoint.getToken(account);
        log.debug("Token: {}",token!=null?"id:"+token.getId()+" token:"+token.getToken().substring(0,10)+"...":null);
        return token;
    }

}
