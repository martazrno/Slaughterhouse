package via.pro3.restanimalservice.model;

import jakarta.persistence.*;
        import java.time.LocalDate;

@Entity
@Table(name = "animal_registration")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private double weight;
    private String registrationNumber;
    private String origin;

    //getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;}

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date;}

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight;}

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber;}

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin;}
}