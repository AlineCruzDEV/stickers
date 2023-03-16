package com.adatech.stickers.repository;
import com.adatech.stickers.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}
