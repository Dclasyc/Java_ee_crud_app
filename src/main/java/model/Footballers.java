package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Footballers {
    @Id
    //Generate Sequence
    @SequenceGenerator(
            name = "footballer_sequence",
            sequenceName = "footballer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "footballer_sequence"
    )

    //Declare class variables
    private long id;
    private String name;
    private String email;
    private String club;
    private LocalDate dob;
    @Transient
    private int age;

    // Generate 3 Constructors

    // 1. No Args Constructors
    public Footballers() {
    	
    }

    // 2. All Args Constructors
    public Footballers(long id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.club = club;
        this.dob = dob;
    }

    // 3 No {ID}Args Constructors

    public Footballers(long id,
                      String name,
                      String email,
                      String club,
                      LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.club = club;
        this.dob = dob;
    }


    // Generate Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Generate toString()
    @Override
    public String toString() {
        return "Footballer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", club='" + club + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }

}
