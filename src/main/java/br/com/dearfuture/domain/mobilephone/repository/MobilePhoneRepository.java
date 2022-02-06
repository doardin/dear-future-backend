package br.com.dearfuture.domain.mobilephone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dearfuture.domain.mobilephone.entity.MobilePhone;

@Repository
public interface MobilePhoneRepository extends JpaRepository<MobilePhone, String> {
    
}