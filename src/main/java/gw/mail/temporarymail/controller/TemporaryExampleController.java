package gw.mail.temporarymail.controller;

import gw.mail.temporarymail.domain.Account;
import gw.mail.temporarymail.domain.Domain;
import gw.mail.temporarymail.domain.Token;
import gw.mail.temporarymail.domain.Message;
import gw.mail.temporarymail.dto.ResponseDTO;
import gw.mail.temporarymail.service.AccountService;
import gw.mail.temporarymail.service.DomainService;
import gw.mail.temporarymail.service.TokenService;
import gw.mail.temporarymail.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@AllArgsConstructor
@Slf4j
public class TemporaryExampleController {

    private final DomainService domainService;

    private final AccountService accountService;

    private final TokenService tokenService;

    private final MessageService messageService;

    /**
     * Account need only the address and password
     *
     * @param account
     * @return
     */
    @PostMapping(value = "createTemporaryEmail")
    public ResponseEntity createTemporaryEmail(@RequestBody Account account){
        try {
            if(account.getAddress().contains("@")){
                throw new RuntimeException("Inform an email without domain");
            }
            log.debug("Creating email {}",account);
            String email;
            List<Domain> domains = domainService.getDomains();
            Account accountCreated;
            if(!domains.isEmpty()){
                email = account.getAddress()+"@"+domains.get(0).getDomain();
                account.setAddress(email);
                accountCreated = accountService.create(account);
            } else {
                throw new RuntimeException("No domains");
            }
            return new ResponseEntity<>(new ResponseDTO(true,"Success",accountCreated), HttpStatus.OK);
        } catch (Exception e){
            log.error("Error: {}, Cause: {}",e.getMessage(),e.getCause()!=null?e.getCause().getMessage():"Unknown");
            return new ResponseEntity<>(new ResponseDTO(false,e.getMessage(),null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "getMessages/{accountId}/{emailId}/{password}")
    public ResponseEntity getMessages(@PathVariable("accountId")String accountId, @PathVariable("emailId")String emailId, @PathVariable("password")String password){
        try {
            List<Message> messages = messageService.getMessages(getAuthorization(emailId,password));
            return new ResponseEntity<>(new ResponseDTO(true,"Success",messages), HttpStatus.OK);
        } catch (Exception e){
            log.error("Error: {}, Cause: {}",e.getMessage(),e.getCause()!=null?e.getCause().getMessage():"Unknown");
            return new ResponseEntity<>(new ResponseDTO(false,e.getMessage(),null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "getMessage/{messageId}/{emailId}/{password}")
    public ResponseEntity getMessage(@PathVariable("messageId")String messageId, @PathVariable("emailId")String emailId, @PathVariable("password")String password){
        try {
            Message message = messageService.getMessage(getAuthorization(emailId,password),messageId);
            return new ResponseEntity<>(new ResponseDTO(true,"Success",message), HttpStatus.OK);
        } catch (Exception e){
            log.error("Error: {}, Cause: {}",e.getMessage(),e.getCause()!=null?e.getCause().getMessage():"Unknown");
            return new ResponseEntity<>(new ResponseDTO(false,e.getMessage(),null), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "delete/{messageId}/{emailId}/{password}")
    public ResponseEntity delete(@PathVariable("messageId")String messageId, @PathVariable("emailId")String emailId, @PathVariable("password")String password){
        try {
            messageService.deleteMessage(getAuthorization(emailId,password),messageId);
            return new ResponseEntity<>(new ResponseDTO(true,"Success",null), HttpStatus.OK);
        } catch (Exception e){
            log.error("Error: {}, Cause: {}",e.getMessage(),e.getCause()!=null?e.getCause().getMessage():"Unknown");
            return new ResponseEntity<>(new ResponseDTO(false,e.getMessage(),null), HttpStatus.BAD_REQUEST);
        }
    }

    private String getAuthorization(String emailId, String password) {
        Token token = tokenService.getToken(Account.builder().address(emailId).password(password).build());
        return "Bearer " + token.getToken();
    }
}
