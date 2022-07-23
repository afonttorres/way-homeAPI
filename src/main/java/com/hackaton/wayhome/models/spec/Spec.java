package com.hackaton.wayhome.models.spec;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackaton.wayhome.models.housing.Housing;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "specs")
public class Spec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    SpecType spec;

    @ManyToOne
    @JoinColumn(name = "housing_id")
    @JsonIgnore
    private Housing housing;

}
