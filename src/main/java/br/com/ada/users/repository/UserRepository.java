package br.com.ada.users.repository;

import br.com.ada.users.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}
