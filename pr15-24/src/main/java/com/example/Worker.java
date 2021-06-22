package com.example;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @SequenceGenerator(name = "workers_seq", sequenceName =
            "workers_sequence", allocationSize = 1)
    @GeneratedValue(generator = "workers_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "middle_name")
    String middleName;
    @ManyToOne(targetEntity = Manufacture.class)
    @JoinColumn(name = "manufacture_id")
    @JsonIgnore
    public Manufacture manufacture;

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public Worker(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public Worker() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
