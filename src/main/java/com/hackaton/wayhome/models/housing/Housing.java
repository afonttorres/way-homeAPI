package com.hackaton.wayhome.models.housing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackaton.wayhome.models.picture.Picture;
import com.hackaton.wayhome.models.client.Publisher;
import com.hackaton.wayhome.models.pet.Pet;
import com.hackaton.wayhome.models.spec.Spec;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "housings")
@AllArgsConstructor
@NoArgsConstructor
public class Housing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    String title;
    @NotNull
    String description;
    Category category;
    boolean isActive;
    @NotNull
    String country;
    @NotNull
    String citty;
    String address;
    @NotNull
    Double price;
    int ratio;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar createdDate;

    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToMany(mappedBy = "housing")
    List<Pet> pets = new ArrayList<>();

    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToMany(mappedBy = "housing")
    List<Picture> pictures = new ArrayList<>();

    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JsonIgnore
    @OneToMany(mappedBy = "housing")
    List<Spec> specs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

}
