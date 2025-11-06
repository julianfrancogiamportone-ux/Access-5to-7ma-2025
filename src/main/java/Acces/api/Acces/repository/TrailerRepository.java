package Acces.api.Acces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Acces.api.Acces.entity.Trailer;

@Repository
public interface TrailerRepository extends JpaRepository<Trailer, Long> {
}