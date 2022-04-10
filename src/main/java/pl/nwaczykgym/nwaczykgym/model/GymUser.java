package pl.nwaczykgym.nwaczykgym.model;

import pl.nwaczykgym.nwaczykgym.Gender;
import pl.nwaczykgym.nwaczykgym.TypeOfUser;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GymUser {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private TypeOfUser userType;
    private Long pesel;
    private String address;
    private String city;
    private String postCode;
    private String contactNumber;
    private String dateOfBirth;
    private String registrationDate;
    private String gymAccessFrom;
    private String gymAccessTo;


    public GymUser(Long id,
                   String name,
                   String surname,
                   Gender gender,
                   TypeOfUser userType,
                   Long pesel,
                   String address,
                   String city,
                   String postCode,
                   String contactNumber,
                   String dateOfBirth,
                   String registrationDate,
                   String gymAccessFrom,
                   String gymAccessTo)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.userType = userType;
        this.pesel = pesel;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.gymAccessFrom = gymAccessFrom;
        this.gymAccessTo = gymAccessTo;
    }

    public GymUser(){

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGymAccessFrom() {
        return gymAccessFrom;
    }

    public String getGymAccessTo() {
        return gymAccessTo;
    }

    public Long getId() {
        return id;
    }

    public TypeOfUser getUserType() {
        return userType;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public Long getPesel() {
        return pesel;
    }
}
