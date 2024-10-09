package sdu.shopWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdu.shopWeb.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
