package gw.mail.temporarymail.domain;

import lombok.Data;

@Data
public class Domain {
    private String id;
    private String domain;
    private Boolean isActive;
    private String createdAt;
    private String updatedAt;

}
