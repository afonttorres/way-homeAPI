package com.hackaton.wayhome.models.picture;

import com.hackaton.wayhome.models.housing.Housing;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    String url;
    @ManyToOne
    @JoinColumn(name = "housing_id")
    Housing housing;
}
