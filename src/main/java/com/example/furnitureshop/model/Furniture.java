package com.example.furnitureshop.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "furniture")
public class Furniture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size (min = 3, max = 200)
    @NotNull
    @NotBlank
    private String name;

    @Size (min = 3, max = 100000)
    @NotNull
    @NotBlank
    private String description;

    @Size (min = 3, max = 200)
    @NotNull
    @NotBlank
    private String producer;

    @Min(1)
    @Max(1000000)
    @NotNull
    private BigDecimal price;

    @Min (1)
    @Max (100000)
    @NotNull
    private int availableAmount;
}
