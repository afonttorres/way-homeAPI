package com.hackaton.wayhome.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    String title;
    String description;
    String category;
    String animal;
    boolean isActive;
    String imgUrl1;
    String imgUrl2;
    String imgUrl3;
    String location;
    Double price;
    int ratio;

    @JsonIgnore
    @OneToMany(mappedBy = "housing")
    List<Spec> specs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Seller publisher;

}
