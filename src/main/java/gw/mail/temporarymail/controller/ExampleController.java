package gw.mail.temporarymail.controller;

import gw.mail.temporarymail.service.DomainService;
import gw.mail.temporarymail.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@AllArgsConstructor
@Slf4j
public class ExampleController {

    private final DomainService domainService;

    @GetMapping(value = "domain")
    public ResponseEntity getDomains(){
        try {
            return new ResponseEntity<>(new ResponseDTO(true,"Success",domainService.getDomains()), HttpStatus.OK);
        } catch (Exception e){
            log.error("Error: {}, Cause: {}",e.getMessage(),e.getCause()!=null?e.getCause().getMessage():"Unknown");
            return new ResponseEntity<>(new ResponseDTO(false,e.getMessage(),null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "domain/{id}")
    public ResponseEntity getDomains(@PathVariable("id")String id){
        try {
            return new ResponseEntity<>(new ResponseDTO(true,"Success",domainService.getDomain(id)), HttpStatus.OK);
        } catch (Exception e){
            log.error("Error: {}, Cause: {}",e.getMessage(),e.getCause()!=null?e.getCause().getMessage():"Unknown");
            return new ResponseEntity<>(new ResponseDTO(false,e.getMessage(),null), HttpStatus.BAD_REQUEST);
        }
    }


}
