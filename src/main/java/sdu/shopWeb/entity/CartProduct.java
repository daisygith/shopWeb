package sdu.shopWeb.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long cartId;

//    private Long productId;

    private int quantity;

    @OneToOne
    @JoinColumn(name= "cardId", nullable = true)
    private Cart cart;

    @OneToMany
    @JoinColumn(name= "productId", nullable = true)
    private List<Product> products;
}
