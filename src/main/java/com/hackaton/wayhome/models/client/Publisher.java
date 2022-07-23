package com.hackaton.wayhome.models.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

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
}


