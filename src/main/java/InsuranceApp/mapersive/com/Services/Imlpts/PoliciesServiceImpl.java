package InsuranceApp.mapersive.com.Services.Imlpts;

import InsuranceApp.mapersive.com.Entities.Policies;
import InsuranceApp.mapersive.com.Repositories.PoliciesRepository;
import InsuranceApp.mapersive.com.Services.PoliciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PoliciesServiceImpl implements PoliciesService {

    @Autowired
    private PoliciesRepository policiesRepository;
    @Override
    public Policies saveNewPolicie(Policies policies) {
        return policiesRepository.save(policies);
    }

    @Override
    public boolean policieExists(Policies policie) {
        return policiesRepository.existsById(policie.getPolicyId());
    }

    @Override
    public Policies getPolicieById(String id) {
        Integer i = Integer.valueOf(id);
        return policiesRepository.findByPolicyId(i);
    }

    @Override
    public Collection<Policies> getAllPolicies() {
        return policiesRepository.findAll();
    }

    @Override
    public Page<Policies> getAllPolicies(Pageable pageable) {
        return policiesRepository.findAll(pageable);    }

    @Override
    public Page<Policies> getAllPoliciesByCustomer(int id, Pageable pageable) {
        return policiesRepository.findByCustomerCustomerId(id,pageable);
    }

    @Override
    public Page<Policies> getPolicies(Pageable pageable) {
        return policiesRepository.findAll(pageable);
    }

}
