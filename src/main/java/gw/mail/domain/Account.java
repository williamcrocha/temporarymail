package gw.mail.temporarymail.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private String id;
    private String address;
    private Integer quota;
    private Integer used;
    private Boolean isDisabled;
    private Boolean isDeleted;
    private String createdAt;
    private String updatedAt;
    private String retentionAt;
    private String password;
}
