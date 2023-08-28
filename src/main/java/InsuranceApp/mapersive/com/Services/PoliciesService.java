package InsuranceApp.mapersive.com.Services;

import InsuranceApp.mapersive.com.Entities.Customer;
import InsuranceApp.mapersive.com.Entities.Policies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface PoliciesService {
    Policies saveNewPolicie(Policies policies);
    boolean policieExists(Policies policie);
    Policies getPolicieById(String id);
    Collection<Policies> getAllPolicies();
    Page<Policies> getAllPolicies(Pageable pageable);
    Page<Policies> getAllPoliciesByCustomer(int id,Pageable pageable);
    Page<Policies> getPolicies(Pageable pageable);

}
