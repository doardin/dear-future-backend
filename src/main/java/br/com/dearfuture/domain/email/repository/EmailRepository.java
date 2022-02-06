package br.com.dearfuture.domain.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dearfuture.domain.email.entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, String> {
    
}
