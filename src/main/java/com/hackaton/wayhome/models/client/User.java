package com.hackaton.wayhome.models.client;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackaton.wayhome.models.pet.Pet;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String name;
    private String surname;
    @NotNull
    private String username;
    @NotNull
    private String email;
    private Long phone;
    @JsonIgnore
    @NotNull
    private String password;
    private String avatar;
    private String country;
    private String citty;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar createdDate;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToMany(mappedBy = "user")
    private List<Pet> pets = new ArrayList<>();
}

