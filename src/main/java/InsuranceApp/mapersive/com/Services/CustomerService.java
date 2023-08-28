package InsuranceApp.mapersive.com.Services;

import InsuranceApp.mapersive.com.Entities.Customer;
import org.springframework.stereotype.Service;


public interface CustomerService {
    public Customer saveNewCustomer(Customer customer);

    boolean customerExists(Customer customer);
}
