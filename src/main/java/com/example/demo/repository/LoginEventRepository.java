
package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;

public interface LoginEventRepository {
    LoginEvent save(LoginEvent e);
    List<LoginEvent> findByUserId(Long id);
    List<LoginEvent> findByUserIdAndLoginStatus(Long id, String status);
}
