package com.hackaton.wayhome.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String username;
    private String email;
    private String avatarUrl;
    private String location;
}
