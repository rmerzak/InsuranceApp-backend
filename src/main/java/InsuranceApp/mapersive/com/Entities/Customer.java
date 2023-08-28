package InsuranceApp.mapersive.com.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Customers")
public class Customer {

    @Id
    @Column(name = "Customer_id")
    private int customerId;

    @Column(name = "Customer_Gender")
    private String customerGender;

    @Column(name = "Customer_Income_group")
    private String customerIncomeGroup;

    @Column(name = "Customer_Region")
    private String customerRegion;

    @Column(name = "Customer_Marital_status")
    private int customerMaritalStatus;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private Set<Policies> policies;

    // Constructors, getters, setters, and other methods
}
