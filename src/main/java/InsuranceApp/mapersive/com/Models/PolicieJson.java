package InsuranceApp.mapersive.com.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PolicieJson {
        @JsonProperty("Policy_id")
        private int Policy_id;

        @JsonProperty("Date_of_Purchase")
        private String Date_of_Purchase;

        @JsonProperty("Customer_id")
        private int Customer_id;

        @JsonProperty("Fuel")
        private String Fuel;

        @JsonProperty("VEHICLE_SEGMENT")
        private String VEHICLE_SEGMENT;

        @JsonProperty("Premium")
        private BigDecimal Premium;

        @JsonProperty("bodily_injury_liability")
        private int bodily_injury_liability;

        @JsonProperty("personal_injury_protection")
        private int personal_injury_protection;

        @JsonProperty("property_damage_liability")
        private int property_damage_liability;

        @JsonProperty("collision")
        private int collision;

        @JsonProperty("comprehensive")
        private int comprehensive;

        @JsonProperty("Customer_Gender")
        private String Customer_Gender;

        @JsonProperty("Customer_Income_group")
        private String Customer_Income_group;

        @JsonProperty("Customer_Region")
        private String Customer_Region;

        @JsonProperty("Customer_Marital_status")
        private int Customer_Marital_status;
        public int getPolicy_id() {
                return Policy_id;
        }

        public void setPolicy_id(int policy_id) {
                Policy_id = policy_id;
        }

        public String getDate_of_Purchase() {
                return Date_of_Purchase;
        }

        public void setDate_of_Purchase(String date_of_Purchase) {
                Date_of_Purchase = date_of_Purchase;
        }

        public int getCustomer_id() {
                return Customer_id;
        }

        public void setCustomer_id(int customer_id) {
                Customer_id = customer_id;
        }

        public String getFuel() {
                return Fuel;
        }

        public void setFuel(String fuel) {
                Fuel = fuel;
        }

        public String getVEHICLE_SEGMENT() {
                return VEHICLE_SEGMENT;
        }

        public void setVEHICLE_SEGMENT(String VEHICLE_SEGMENT) {
                this.VEHICLE_SEGMENT = VEHICLE_SEGMENT;
        }

        public BigDecimal getPremium() {
                return Premium;
        }

        public void setPremium(BigDecimal premium) {
                Premium = premium;
        }

        public int getBodily_injury_liability() {
                return bodily_injury_liability;
        }

        public void setBodily_injury_liability(int bodily_injury_liability) {
                this.bodily_injury_liability = bodily_injury_liability;
        }

        public int getPersonal_injury_protection() {
                return personal_injury_protection;
        }

        public void setPersonal_injury_protection(int personal_injury_protection) {
                this.personal_injury_protection = personal_injury_protection;
        }

        public int getProperty_damage_liability() {
                return property_damage_liability;
        }

        public void setProperty_damage_liability(int property_damage_liability) {
                this.property_damage_liability = property_damage_liability;
        }

        public int getCollision() {
                return collision;
        }

        public void setCollision(int collision) {
                this.collision = collision;
        }

        public int getComprehensive() {
                return comprehensive;
        }

        public void setComprehensive(int comprehensive) {
                this.comprehensive = comprehensive;
        }

        public String getCustomer_Gender() {
                return Customer_Gender;
        }

        public void setCustomer_Gender(String customer_Gender) {
                Customer_Gender = customer_Gender;
        }

        public String getCustomer_Income_group() {
                return Customer_Income_group;
        }

        public void setCustomer_Income_group(String customer_Income_group) {
                Customer_Income_group = customer_Income_group;
        }

        public String getCustomer_Region() {
                return Customer_Region;
        }

        public void setCustomer_Region(String customer_Region) {
                Customer_Region = customer_Region;
        }

        public int getCustomer_Marital_status() {
                return Customer_Marital_status;
        }

        public void setCustomer_Marital_status(int customer_Marital_status) {
                Customer_Marital_status = customer_Marital_status;
        }

}
