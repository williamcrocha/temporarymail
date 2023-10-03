package gw.mail.temporarymail.api;

import gw.mail.temporarymail.domain.Domain;
import gw.mail.temporarymail.dto.DomainResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "domain",url = "https://api.mail.gw/domains")
public interface DomainEndpoint {

    @GetMapping
    DomainResultDTO getDomains();

    @GetMapping(value = "/{id}")
    Domain getDomain(@PathVariable("id")String id);

}
