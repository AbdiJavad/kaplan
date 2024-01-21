package com.avin.kaplan.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;


@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date dateCreated;
    private double weight;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductType productType;


}