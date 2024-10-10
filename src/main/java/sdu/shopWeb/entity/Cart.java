package sdu.shopWeb.entity;

import jakarta.persistence.*;
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
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double sumPrice;

    @OneToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    @OneToMany
    private List<Product> products;
}
