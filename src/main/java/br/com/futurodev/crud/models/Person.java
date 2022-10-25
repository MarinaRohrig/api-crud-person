package br.com.futurodev.crud.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  //  @Column(name = "birth_date")
  //  private Date birthDate;

  //  @Column(name = "time_of_birth")
   // private LocalTime timeOfBirth;

    @Column(name = "email", unique = true)
    private String email;

    @Column (name = "state")
    private String state;

    @Column (name = "city")
    private String city;

    @Column (name = "street")
    private String street;

    @Column (name = "cep",length = 9)
    private String cep;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   /* public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public LocalTime getTimeOfBirth() {
        return timeOfBirth;
    }

    public void setTimeOfBirth(LocalTime timeOfBirth) {
        this.timeOfBirth = timeOfBirth;
    }
    */


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
