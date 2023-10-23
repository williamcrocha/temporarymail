package gw.mail.temporarymail.service;

import gw.mail.temporarymail.api.AccountEndpoint;
import gw.mail.temporarymail.domain.Account;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AccountService {

    private final AccountEndpoint accountEndpoint;

    public Account create(Account account){
        log.info("Creating account {}",account);
        Account accountCreated = accountEndpoint.createAccount(account);
        log.debug("Account created: {}",accountCreated);
        return accountCreated;
    }

    /**
     *
     * @param id
     * @param authorization - must have "Bearer " at begin
     * @return
     */
    public Account getAccount(String id, String authorization){
        log.info("Getting by account id {}",id);
        Account account = accountEndpoint.getAccount(authorization, id);
        log.debug("Account: {}",account);
        return account;
    }

}
