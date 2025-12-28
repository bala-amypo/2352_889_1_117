
// package com.example.demo.repository;

// import com.example.demo.entity.PolicyRule;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import java.util.List;

// @Repository
// public interface PolicyRuleRepository extends JpaRepository<PolicyRule, Long> {
//     List<PolicyRule> findByActiveTrue();
// }

package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;

public interface PolicyRuleRepository {
    PolicyRule save(PolicyRule r);
    List<PolicyRule> findByActiveTrue();
    List<PolicyRule> findAll();
}
