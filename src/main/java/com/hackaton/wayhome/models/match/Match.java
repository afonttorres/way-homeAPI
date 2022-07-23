package com.hackaton.wayhome.models.match;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackaton.wayhome.models.housing.Housing;
import com.hackaton.wayhome.models.client.Publisher;
import com.hackaton.wayhome.models.client.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonIgnore
    private Publisher publisher;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "housing_id")
    private Housing housing;
    MatchStatus status = MatchStatus.pending;
}
