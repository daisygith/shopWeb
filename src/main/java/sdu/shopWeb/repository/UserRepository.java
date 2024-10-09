package sdu.shopWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdu.shopWeb.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
