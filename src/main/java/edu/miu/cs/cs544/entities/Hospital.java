package edu.miu.cs.cs544.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer yearBuilt;
    private Integer capacity;
    @OneToMany
    private List<Patient> patients;

    public Hospital(){}

    public Hospital(String name, Integer yearBuilt, Integer capacity, List<Patient> patients) {
        this.name = name;
        this.yearBuilt = yearBuilt;
        this.capacity = capacity;
        this.patients = patients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", yearBuilt=" + yearBuilt +
                ", capacity=" + capacity +
                ", patients=" + patients +
                '}';
    }


}
