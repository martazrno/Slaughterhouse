package via.pro3.restanimalservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import via.pro3.restanimalservice.model.Animal;
import via.pro3.restanimalservice.repository.AnimalRepo;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalRepo repo;

    public AnimalController(AnimalRepo repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Animal> register(@RequestBody Animal animal) {
        return ResponseEntity.ok(repo.save(animal));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/date/{date}")
    public List<Animal> getByDate(@PathVariable String date) {
        return repo.findByDate(LocalDate.parse(date));
    }

    @GetMapping("/origin/{origin}")
    public List<Animal> getByOrigin(@PathVariable String origin) {
        return repo.findByOrigin(origin);
    }
}
