package pl.nwaczykgym.nwaczykgym.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode @NoArgsConstructor
@AllArgsConstructor
public class GymUser {

    @Id
    private String id;

    @Column(unique = true)
    private String pesel;

    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private TypeOfUser userType;

    private String address;
    private String city;
    private String postCode;
    private String contactNumber;
    private LocalDate dateOfBirth;
    private LocalDate registrationDate;
    private LocalDate gymAccessFrom;
    private LocalDate gymAccessTo;
}


