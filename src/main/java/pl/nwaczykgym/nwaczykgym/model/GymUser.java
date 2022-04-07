package pl.nwaczykgym.nwaczykgym.model;

import pl.nwaczykgym.nwaczykgym.Gender;
import pl.nwaczykgym.nwaczykgym.TypeOfUser;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class GymUser {

    @Id
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private TypeOfUser userType;
    private String address;
    private String city;
    private String postCode;
    private String contactNumber;
    private Date dateOfBirth;
    private Date registrationDate;
    private Date gymAccessFrom;
    private Date gymAccessTo;


    public GymUser(Long id,
                   String name,
                   String surname,
                   Gender gender,
                   TypeOfUser userType,
                   String address,
                   String city,
                   String postCode,
                   String contactNumber,
                   Date dateOfBirth,
                   Date registrationDate,
                   Date gymAccessFrom,
                   Date gymAccessTo)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.userType = userType;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.gymAccessFrom = gymAccessFrom;
        this.gymAccessTo = gymAccessTo;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getGymAccessFrom() {
        return gymAccessFrom;
    }

    public Date getGymAccessTo() {
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

    public Date getRegistrationDate() {
        return registrationDate;
    }
}
