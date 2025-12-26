
package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.*;
public interface LoginEventService {
    LoginEvent recordLogin(LoginEvent e);
    List<LoginEvent> getEventsByUser(Long id);
    List<LoginEvent> getSuspiciousLogins(Long id);
}
