package sdu.shopWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdu.shopWeb.entity.CartProduct;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
}
