package com.avin.kaplan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Product {
    @Id
    private Long id;
   private String name;
   private Date dateCreated;
   private double weight;

}
