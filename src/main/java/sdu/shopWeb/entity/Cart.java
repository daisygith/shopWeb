package sdu.shopWeb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double sumPrice;

    @OneToOne
    @JoinColumn(name = "userId", nullable = true)
    private Users users;

    @OneToMany
    private List<Product> products;
}
