package com.jkdev.springREST.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "places")
public class Place {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "place")
    //@JoinColumn(name = "places_id")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "place", cascade = CascadeType.ALL)

    private List<Opinion> opinionList;

    public List<Opinion> getOpinionList() {
        return opinionList;
    }

    public void addOpinion(Opinion opinion) {
        if (opinionList == null) {
            opinionList = new ArrayList<>();
        }
        opinion.setPlace(this);
        opinionList.add(opinion);
    }

    public void removeOpinion(Opinion opinion) {
        opinionList.remove(opinion);
    }

    public void setOpinionList(List<Opinion> opinionList) {
        this.opinionList = opinionList;
    }

    public Place(String name, String localisation, String openingHours, String phone) {
        this.name = name;
        this.localisation = localisation;
        this.openingHours = openingHours;
        this.phone = phone;
    }

    public Place() {
    }

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "localisation")
    private String localisation;
    @Column(name = "openingHours")
    private String openingHours;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "phone")
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


}
