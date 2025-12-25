
package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.UserAccount;

public interface UserAccountRepository {
    UserAccount save(UserAccount u);
    Optional<UserAccount> findById(Long id);
    List<UserAccount> findAll();
}
