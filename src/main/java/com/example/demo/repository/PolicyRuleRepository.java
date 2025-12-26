
package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;

public interface PolicyRuleRepository {
    PolicyRule save(PolicyRule r);
    List<PolicyRule> findByActiveTrue();
    List<PolicyRule> findAll();
}
