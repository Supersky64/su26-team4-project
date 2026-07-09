package com.csc340.TrailBuddy.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "outdoor_services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutdoorService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties("outdoorServices")
    private Provider provider;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String skillLevel;

    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "outdoorService")
    @JsonIgnore
    private List<Rsvp> rsvps;

    public OutdoorService(Provider provider, String name, String description, String skillLevel, String location) {
        this.provider = provider;
        this.name = name;
        this.description = description;
        this.skillLevel = skillLevel;
        this.location = location;
    }
}
