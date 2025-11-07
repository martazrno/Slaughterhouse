package via.pro3.restanimalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import via.pro3.restanimalservice.model.Animal;
import java.time.LocalDate;
import java.util.List;

public interface AnimalRepo extends JpaRepository<Animal, Long> {
    List<Animal> findByDate(LocalDate date);
    List<Animal> findByOrigin(String origin);
}