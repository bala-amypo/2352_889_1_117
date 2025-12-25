
package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.LoginEvent;

public interface LoginEventService {

    LoginEvent recordLogin(LoginEvent e);

    List<LoginEvent> getEventsByUser(Long userId);

    List<LoginEvent> getSuspiciousLogins(Long userId);

    List<LoginEvent> getAllEvents();   // ✅ ADD THIS
}
