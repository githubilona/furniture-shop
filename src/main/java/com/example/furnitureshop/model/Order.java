package com.example.furnitureshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "order_info_id")
        @Fetch(value = FetchMode.SUBSELECT)
        private List<CartItem> cartItems;

        @Temporal(TemporalType.DATE)
        @Column(name = "order_date")
        private Date orderDate;

        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        private User user;

        @Column(name = "order_id")
        private Integer orderID;
}
