package com.luv2code.springdemo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Place(String name, String localisation, String openingHours, String phone) {
        this.name = name;
        this.localisation = localisation;
        this.openingHours = openingHours;
        this.phone = phone;
    }

    public Place() {
    }

    @Column(name = "name")
    private String name;


    @Column(name = "localisation")
    private String localisation;
    @Column(name="openingHours")
    private String openingHours;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name="phone")
    private String phone;

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(id, place.id) &&
                Objects.equals(name, place.name) &&
                Objects.equals(localisation, place.localisation) &&
                Objects.equals(openingHours, place.openingHours) &&
                Objects.equals(phone, place.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, localisation, openingHours, phone);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", localisation='" + localisation + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
