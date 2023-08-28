package InsuranceApp.mapersive.com.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Policies")
public class Policies {

    @Id
    @Column(name = "Policy_id")
    private int policyId;

    @Column(name = "Date_of_Purchase")
    private Date dateOfPurchase;

    @ManyToOne
    @JoinColumn(name = "Customer_id")
    @JsonManagedReference
    private Customer customer;

    @Column(name = "Fuel")
    private String fuel;

    @Column(name = "VEHICLE_SEGMENT")
    private String vehicleSegment;

    @Column(name = "Premium")
    private BigDecimal premium;

    @Column(name = "bodily_injury_liability")
    private int bodilyInjuryLiability;

    @Column(name = "personal_injury_protection")
    private int personalInjuryProtection;

    @Column(name = "property_damage_liability")
    private int propertyDamageLiability;

    @Column(name = "collision")
    private int collision;

    @Column(name = "comprehensive")
    private int comprehensive;
}
