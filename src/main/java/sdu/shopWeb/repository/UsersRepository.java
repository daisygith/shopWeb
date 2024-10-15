package sdu.shopWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sdu.shopWeb.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
}
