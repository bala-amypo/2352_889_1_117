
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findByUsername(String username);
}
