package br.com.dearfuture.domain.email.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.dearfuture.domain.letter.entity.Letter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Email {
    
    @Id
    private String id = UUID.randomUUID().toString();

    private String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "email_letter", 
        joinColumns = @JoinColumn(name = "emailId"),
        inverseJoinColumns = @JoinColumn(name = "letterId")
    )
    private List<Letter> letters;


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