package br.com.dearfuture.domain.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dearfuture.domain.mail.entity.Mail;

@Repository
public interface MailRepository extends JpaRepository<Mail, String> {
    public Mail getByAddress(String email);
}
