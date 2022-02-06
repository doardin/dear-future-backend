package br.com.dearfuture.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dearfuture.domain.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
}
