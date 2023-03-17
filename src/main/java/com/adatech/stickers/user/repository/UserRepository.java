package com.adatech.stickers.user.repository;
import com.adatech.stickers.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}
