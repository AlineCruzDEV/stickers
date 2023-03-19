package br.com.ada.users.user.repository;
import br.com.ada.users.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}
