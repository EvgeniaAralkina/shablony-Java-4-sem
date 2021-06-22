package com.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="worker")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Worker {
    @Id
    @SequenceGenerator(name = "worker_seq", sequenceName =
            "worker_sequence", allocationSize = 1)
    @GeneratedValue(generator = "worker_seq", strategy =
            GenerationType.SEQUENCE)
    int id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "middle_name")
    String middleName;
    //@Column(name = "manufacture_id")
    //int manufactureId;

    @ManyToOne(targetEntity = Manufacture.class) // @Column(name = "postoffice")
    @JoinColumn(name = "manufacture_id")
    @JsonIgnore
    public Manufacture manufacture;

    public Worker(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public Worker(int id, String firstName, String lastName, String middleName) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }
}
