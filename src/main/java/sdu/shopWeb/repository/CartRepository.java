package sdu.shopWeb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdu.shopWeb.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}