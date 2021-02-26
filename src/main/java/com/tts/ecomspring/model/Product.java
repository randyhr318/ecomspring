package com.tts.ecomspring.model;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    public class Product

    //ints
        private int quantity;
        private int price;

    // strings
        private String brand;
        private String category;
        private String name;
        private String image;
        private String description;

    {

    }
}
