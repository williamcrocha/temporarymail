package gw.mail.temporarymail.service;

import gw.mail.temporarymail.api.DomainEndpoint;
import gw.mail.temporarymail.domain.Domain;
import gw.mail.temporarymail.dto.DomainResultDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class DomainService {

    private final DomainEndpoint domainEndpoint;

    public List<Domain> getDomains(){
        log.info("Getting domains");
        DomainResultDTO retornoDTO = domainEndpoint.getDomains();
        log.debug("Domains: {}",retornoDTO);
        return retornoDTO.getHydraMember()==null?new ArrayList<>():retornoDTO.getHydraMember();
    }

    public Domain getDomain(String id){
        log.info("Getting domain id {}",id);
        Domain domain = domainEndpoint.getDomain(id);
        log.debug("Domain: {}",domain);
        return domain;
    }

}
