package com.example.furnitureshop.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cart_items")
public class CartItem
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "furniture_id")
        @NotNull
        private Furniture furniture;

        @NotNull
        @Max(10000)
        @Positive
        private Long amount;

        public CartItem(@NotNull Furniture furniture, @NotNull @Max(100000) @Positive Long amount )
        {
                this.furniture = furniture;
                this.amount = amount;
        }
}
