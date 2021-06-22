package com.example;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
//@Table(appliesTo = "manufacture")
@Table(name="manufacture")
public class Manufacture {
    @Id
    @SequenceGenerator(name = "manufacture_seq", sequenceName =
            "worker_sequence", allocationSize = 1)
    @GeneratedValue(generator = "manufacture_seq", strategy =
            GenerationType.SEQUENCE)
    private int id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;
    //@Column(name = "worker_id")
    @Access(AccessType.PROPERTY)
    @OneToMany(mappedBy = "manufacture",targetEntity = Worker.class,cascade = CascadeType.ALL)
    private Set<Worker> workers;

    

    public Manufacture(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Manufacture(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Manufacture() {

    }

    /*public Set getWorkers() {
        return workers;
    }

    public void setWorkers(Set workers) {
        this.workers = workers;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
}
