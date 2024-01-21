package com.avin.kaplan.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@PrimaryKeyJoinColumn(name = "id")
public class Paint extends Product {
    private String name;
    private String code;
}
