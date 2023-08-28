package InsuranceApp.mapersive.com.Repositories;

import InsuranceApp.mapersive.com.Entities.Policies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface PoliciesRepository extends JpaRepository<Policies, Integer> {
    Policies findByPolicyId(int policyId);
    Page<Policies> findByCustomerCustomerId(int customerId, Pageable pageable);

}