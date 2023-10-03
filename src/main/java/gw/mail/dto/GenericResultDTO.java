package gw.mail.temporarymail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GenericResultDTO<T> {
    @JsonProperty("hydra:member")
    List<T> hydraMember;

    @JsonProperty("hydra:totalItems")
    long hydraTotalItens;

}
