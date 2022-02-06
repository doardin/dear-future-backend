package br.com.dearfuture.domain.letter.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.dearfuture.domain.email.entity.Email;
import br.com.dearfuture.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Letter {
    
    @Id
    private String id = UUID.randomUUID().toString();

    private String subject;

    @Lob
    private String text;

    @ManyToOne
    @JoinColumn(name = "userId")
    public User user;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "letters")
    private List<Email> recipients;

    private LocalDate deliveryIn;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    private void prePersist(){
        if(this.createdAt == null) this.createdAt = LocalDateTime.now();
        if(this.updatedAt == null) this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdated(){
        this.updatedAt = LocalDateTime.now();
    }

}