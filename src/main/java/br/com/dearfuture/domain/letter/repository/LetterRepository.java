package br.com.dearfuture.domain.letter.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.dearfuture.domain.letter.entity.Letter;

@Repository
public interface LetterRepository extends JpaRepository<Letter, String> {
    
    @Query("SELECT l FROM Letter l WHERE l.deliveryIn = :deliveryIn")
    public List<Letter> getByDeliveryIn(LocalDate deliveryIn);

}
