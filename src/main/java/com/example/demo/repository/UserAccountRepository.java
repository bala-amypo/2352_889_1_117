
package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;

public interface UserAccountRepository {
    UserAccount save(UserAccount u);
    Optional<UserAccount> findById(Long id);
    List<UserAccount> findAll();
}
