package com.huyle.shop.Respository;

import com.huyle.shop.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.huyle.shop.Exception.ErrorConstants.*;
import java.util.Optional;

public interface UserRespository extends JpaRepository<User, String> {

    Optional<User> findFirstByUsername(String username);

    default User getByUsername(String username) {
        return findFirstByUsername(username).orElseThrow(() => new BadRequestException(USER_KEY, NOT_FOUND));
    }
}
