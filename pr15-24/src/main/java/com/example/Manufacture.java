package com.example;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "manufactures")
//@Getter
//@Setter
public class Manufacture {
    @Id
    @SequenceGenerator(name = "manufactures_seq", sequenceName =
            "manufactures_sequence", allocationSize = 1)
    @GeneratedValue(generator = "manufactures_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;
    @OneToMany(mappedBy = "manufacture",
            targetEntity = Worker.class,cascade = CascadeType.ALL)
    Set<Worker> workerSet;

    public Set<Worker> getWorkerSet() {
        return workerSet;
    }

    public void setWorkerSet(Set<Worker> workerSet) {
        this.workerSet = workerSet;
    }

    public Manufacture(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Manufacture() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
