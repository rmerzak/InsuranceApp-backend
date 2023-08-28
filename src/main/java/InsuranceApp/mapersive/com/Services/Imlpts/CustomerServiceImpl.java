package InsuranceApp.mapersive.com.Services.Imlpts;

import InsuranceApp.mapersive.com.Entities.Customer;
import InsuranceApp.mapersive.com.Repositories.CustomerRepository;
import InsuranceApp.mapersive.com.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer saveNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean customerExists(Customer customer) {
        return customerRepository.existsById(customer.getCustomerId());
    }
}
