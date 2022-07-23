package com.hackaton.wayhome.models.pet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackaton.wayhome.models.client.Publisher;
import com.hackaton.wayhome.models.client.User;
import com.hackaton.wayhome.models.housing.Housing;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pets")
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    String name;
    @NotNull
    PetType type;

    @ManyToOne(optional = true)
    @JsonIgnore
    @JoinColumn(name = "user_id")
    User user;
    @ManyToOne(optional = true)
    @JsonIgnore
    @JoinColumn(name = "housing_id")
    Housing housing;
}
