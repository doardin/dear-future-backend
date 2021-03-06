package br.com.dearfuture.domain.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.dearfuture.domain.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public Optional<User> getUserByEmail(String email);

    public Optional<User> getUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE (u.email = :alias OR u.username = :alias) AND u.password = :password")
    public Optional<User> getUserByEmailOrUsernameAndPassword(String alias, String password);

    @Query("SELECT u FROM User u WHERE u.id = :userId")
    public Optional<User> getUserById(String userId);
}
