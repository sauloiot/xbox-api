package com.ghost.xboxapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ghost.xboxapi.models.enums.StatusEmailEnum;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "email")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID emailId;
//    nome do recebedor
    private String ownerRef;
//    email de quem está enviando
    private String emailFrom;
//    destinatario
    private String emailTo;
//    titulo
    private String subject;
//    corpo
    @JsonIgnore
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private StatusEmailEnum statusEmail;
    private String templateHtml;
    @Transient
    private List<Object> attachments = new ArrayList<>();
    @Transient
    private Map<String, Object> props = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Email email = (Email) o;
        return emailId != null && Objects.equals(emailId, email.emailId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
