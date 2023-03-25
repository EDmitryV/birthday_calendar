package ru.edmitryv.birthday_scheduler.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Person {
    public Person(String full_name, Date date_of_birth){
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
    }

    public Person(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String full_name;
    @Column(name="date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date date_of_birth;

    public Long getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
