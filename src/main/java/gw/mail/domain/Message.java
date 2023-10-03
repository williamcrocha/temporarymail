package gw.mail.temporarymail.domain;

import lombok.Data;

import java.util.List;

@Data
public class Message {
    private String id;
    private String accountId;
    private String msgid;
    private From from;
    private List<To> to;
    private List<Object> cc;
    private List<Object> bcc;
    private String subject;
    private Boolean seen;
    private Boolean flagged;
    private Boolean isDeleted;
    private List<Object> verifications;
    private Boolean retention;
    private String retentionDate;
    private String text;
    private List<String> html;
    private Boolean hasAttachments;
    private List<Object> attachments;
    private Integer size;
    private String downloadUrl;
    private String createdAt;
    private String updatedAt;
}
