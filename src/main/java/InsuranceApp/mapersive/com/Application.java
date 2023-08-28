package InsuranceApp.mapersive.com;

import InsuranceApp.mapersive.com.Entities.Customer;
import InsuranceApp.mapersive.com.Entities.Policies;
import InsuranceApp.mapersive.com.Models.PolicieJson;
import InsuranceApp.mapersive.com.Services.CustomerService;
import InsuranceApp.mapersive.com.Services.PoliciesService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@JsonIgnoreProperties(ignoreUnknown = true)
	CommandLineRunner runner(CustomerService customerService, PoliciesService policiesService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<PolicieJson>> typeReference = new TypeReference<List<PolicieJson>>() {
			};

			InputStream inputStream = TypeReference.class.getClassLoader().getResourceAsStream("insurance.json");

			try {
				List<PolicieJson> policies = mapper.readValue(inputStream, typeReference);
				for (PolicieJson policy : policies) {
					Customer customer = Customer.builder().customerId(policy.getCustomer_id())
							.customerGender(policy.getCustomer_Gender())
							.customerRegion(policy.getCustomer_Region())
							.customerIncomeGroup(policy.getCustomer_Income_group())
							.customerMaritalStatus(policy.getCustomer_Marital_status())
							.build();
					Policies policie = Policies.builder().policyId(policy.getPolicy_id())
							.dateOfPurchase(parseDate(policy.getDate_of_Purchase()))
							.customer(customer)
							.fuel(policy.getFuel())
							.vehicleSegment(policy.getVEHICLE_SEGMENT())
							.premium(policy.getPremium())
							.bodilyInjuryLiability(policy.getBodily_injury_liability())
							.personalInjuryProtection(policy.getPersonal_injury_protection())
							.propertyDamageLiability(policy.getProperty_damage_liability())
							.collision(policy.getCollision())
							.comprehensive(policy.getComprehensive())
							.build();
					if (!customerService.customerExists(customer)) {
						customerService.saveNewCustomer(customer);
					}
					if (!policiesService.policieExists(policie)) {
						policiesService.saveNewPolicie(policie);
					}
				}
			} catch (IOException e) {
				System.out.println("Error reading JSON: " + e.getMessage());
			}
		};
	}

	private Date parseDate(String dateStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException("Error parsing date: " + e.getMessage());
		}
	}
}
