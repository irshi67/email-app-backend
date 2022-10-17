package com.example.emailapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "mails")
@TypeAlias("Mail")
@Accessors(chain = true)
public class Mail extends Base {
    private String from;
    private ArrayList<String> to = new ArrayList<>();
    private String subject;
    private String message;
    private String reply;
    private MailStatus status;
    private boolean isRead;
}
