package gw.mail.temporarymail.api;

import gw.mail.temporarymail.domain.Message;
import gw.mail.temporarymail.dto.MessageResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "message",url = "https://api.mail.gw/messages")
public interface MessageEndpoint {

    @GetMapping
    MessageResultDTO getMessages(@RequestHeader(value = "Authorization",required = true) String authorization);

    @GetMapping(value = "/{id}")
    Message getMessage(@RequestHeader(value = "Authorization",required = true) String authorization, @PathVariable("id") String id);

    @DeleteMapping(value = "/{id}")
    void deleteMessage(@RequestHeader(value = "Authorization",required = true) String authorization, @PathVariable("id") String id);

}
