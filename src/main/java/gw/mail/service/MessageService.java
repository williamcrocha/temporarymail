package gw.mail.temporarymail.service;

import gw.mail.temporarymail.api.MessageEndpoint;
import gw.mail.temporarymail.domain.Message;
import gw.mail.temporarymail.dto.MessageResultDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MessageService {

    private final MessageEndpoint messageEndpoint;

    /**
     *
     * @param authorization - must have "Bearer " at begin
     * @return
     */
    public List<Message> getMessages(String authorization){
        log.info("Getting messages");
        MessageResultDTO messageResultDTO = messageEndpoint.getMessages(authorization);
        log.debug("Messages: {}",messageResultDTO);
        return messageResultDTO.getHydraMember()==null?new ArrayList<>():messageResultDTO.getHydraMember();
    }

    /**
     *
     * @param authorization - must have "Bearer " at begin
     * @param id
     * @return
     */
    public Message getMessage(String authorization, String id){
        log.info("Getting message id:{}",id);
        Message message = messageEndpoint.getMessage(authorization,id);
        log.debug("Message: {}",message);
        return message;
    }

    /**
     *
     * @param authorization - must have "Bearer " at begin
     * @param id
     * @return
     */
    public void deleteMessage(String authorization, String id){
        log.info("Deleting message id:{}",id);
        messageEndpoint.deleteMessage(authorization,id);
        log.debug("Message {} deleted",id);
    }

}
