package com.hackaton.wayhome.models.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackaton.wayhome.models.housing.Housing;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "publishers")
public class Publisher{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String name;
    @Nullable
    private String surname;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @Nullable
    private Long phone;
    @JsonIgnore
    @NotNull
    private String password;
    @Nullable
    private String avatar;
    private String country;
    private String citty;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar createdDate;


    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private List<Housing> housings = new ArrayList<>();
}


