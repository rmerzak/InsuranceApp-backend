# InsuranceApp (Backend)

## 1. Getting started

### 1.1. Récupérer les sources

```
$ git clone https://github.com/rmerzak/InsuranceApp-backend.git
```

### 1.2. Lancer l'application

```
$ mvn spring-boot:run
```

### 1.3. API

Method | Path           | Description                    |
-------|----------------|--------------------------------|
GET    | /api/v1/policies/All        | retrieve all the policies in our database |
GET    | /api/v1/policies/{numero}      | retrieve one policies by its ID      |
GET    | /api/v1/policies/page        | retrieve paginated policies|
GET    | /api/v1/policies/pageCus/{customerId}        | retrieve paginated policies for a cusomer by his ID |
GET    | /api/v1/policies/pagesort        | retrieve paginated policies sorted by date |
GET    | /api/v1/policies/pagesortprem      | retrieve paginated policies sorted by premium numbers |


```
$ curl -X GET "http://localhost:8080/api/v1/policies/page?page=1&size=10" -H "accept: application/json"

$ curl -X GET "http://localhost:8080/api/v1/policies/pageCus/{id}?page=1&size=10" -H "accept: application/json"

$ curl -X GET "http://localhost:8080/api/v1/policies/pagesort?page=1&size=10&sort=sortField,sortOrder" -H "accept: application/json"

$ curl -X GET "http://localhost:8080/api/v1/policies/pagesortprem?page=1&size=10&sort=sortField,sortOrder" -H "accept: application/json"
```
## 2. Tutoriel

### 2.1. General Overview

Spring Boot is a framework for rapidly building feature-rich Java/JEE applications, whether they are web-based or standalone.
It speeds up software development by offering a set of conventions, abstractions, and ready-to-use mechanisms.
In practical terms, Spring Boot is structured as a parent POM (Project Object Model) and dependencies, also known as "starters," managed through tools like Maven or Gradle.

## 2.2 Tutorial Objective
In this tutorial, we will learn how to:

- Set up, configure, and start a web application using Spring Boot.
- Integrate the Lombok library to reduce boilerplate code (e.g., getters/setters/equals/hashCode).
- Declare a JPA Entity (for persistence) and a corresponding complete Repository!
- Define a REST/JSON/HTTP Resource.

### 2.3. Initializing a Web Project with Spring Boot

we create the following directory structure:

```
├── README.md
├── backend
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── InsuranceApp
│       │   │       └── mapersive
│       │   │           └── com
│       │   │               ├── Application.java
│       │   │               ├── Controllers
│       │   │               │   ├── CustomerController.java
│       │   │               │   └── PoliciesController.java
│       │   │               ├── Entities
│       │   │               │   ├── Customer.java
│       │   │               │   └── Policies.java
│       │   │               ├── Models
│       │   │               │   └── PolicieJson.java
│       │   │               ├── Repositories
│       │   │               │   ├── CustomerRepository.java
│       │   │               │   └── PoliciesRepository.java
│       │   │               └── Services
│       │   │                   ├── CustomerService.java
│       │   │                   ├── Imlpts
│       │   │                   │   ├── CustomerServiceImpl.java
│       │   │                   │   └── PoliciesServiceImpl.java
│       │   │                   └── PoliciesService.java
│       │   └── resources
│       │       ├── application.properties
│       │       ├── insurance.json
│       │       └── static
│       │           ├── insurance.json
│       │           └── json
│       │               └── insurance.json
│       └── test
│           └── java
│               └── InsuranceApp
│                   └── mapersive
│                       └── com
│                           └── ApplicationTests.java
```

Create the file ```./pom.xml``` (for Maven):


```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.0.10</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>InsuranceApp.mapersive.com </groupId>
	<artifactId>demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>demo</name>
	<description>InsuranceApp SpringBoot Angular</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

```

Créez la classe ```/backend/src/main/java/InsuranceApp/mapersive/com/Application.java``` :

```
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

```

The annotation @SpringBootApplication indicates that it's a Spring Boot application.

The statement SpringApplication.run(Application.class, args); launches the application using an embedded server, directly from the main method (right-click -> run the application from the main method).
Launch the application:

- Either using the command line: $ mvn spring-boot:run
- Or from the main method (as mentioned above)

```
/Users/rmerzak/Library/Java/JavaVirtualMachines/openjdk-20.0.2/Contents/Home/bin/java
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v3.0.10)

2023-08-28T16:41:07.168+01:00  INFO 26243 --- [  restartedMain] InsuranceApp.mapersive.com.Application   : Starting Application using Java 20.0.2 with PID 26243 (/Users/rmerzak/Desktop/files/Project/backend/target/classes started by rmerzak in /Users/rmerzak/Desktop/files/Project/backend)
2023-08-28T16:41:07.179+01:00  INFO 26243 --- [  restartedMain] InsuranceApp.mapersive.com.Application   : No active profile set, falling back to 1 default profile: "default"
2023-08-28T16:41:07.585+01:00  INFO 26243 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2023-08-28T16:41:07.585+01:00  INFO 26243 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2023-08-28T16:41:13.251+01:00  INFO 26243 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2023-08-28T16:41:13.256+01:00  INFO 26243 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JDBC repositories in DEFAULT mode.
2023-08-28T16:41:13.387+01:00  INFO 26243 --- [  restartedMain] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface InsuranceApp.mapersive.com.Repositories.CustomerRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2023-08-28T16:41:13.388+01:00  INFO 26243 --- [  restartedMain] .RepositoryConfigurationExtensionSupport : Spring Data JDBC - Could not safely identify store assignment for repository candidate interface InsuranceApp.mapersive.com.Repositories.PoliciesRepository; If you want this repository to be a JDBC repository, consider annotating your entities with one of these annotations: org.springframework.data.relational.core.mapping.Table.
2023-08-28T16:41:13.388+01:00  INFO 26243 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 101 ms. Found 0 JDBC repository interfaces.
2023-08-28T16:41:13.480+01:00  INFO 26243 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2023-08-28T16:41:13.497+01:00  INFO 26243 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2023-08-28T16:41:13.625+01:00  INFO 26243 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 107 ms. Found 2 JPA repository interfaces.
2023-08-28T16:41:17.482+01:00  INFO 26243 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-08-28T16:41:17.964+01:00  INFO 26243 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-08-28T16:41:17.964+01:00  INFO 26243 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.12]
2023-08-28T16:41:18.592+01:00  INFO 26243 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-08-28T16:41:18.592+01:00  INFO 26243 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 11007 ms
2023-08-28T16:41:18.742+01:00  INFO 26243 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2023-08-28T16:41:20.826+01:00  INFO 26243 --- [  restartedMain] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:testdb user=SA
2023-08-28T16:41:20.829+01:00  INFO 26243 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2023-08-28T16:41:20.859+01:00  INFO 26243 --- [  restartedMain] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'
2023-08-28T16:41:21.652+01:00  INFO 26243 --- [  restartedMain] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2023-08-28T16:41:22.209+01:00  INFO 26243 --- [  restartedMain] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.1.7.Final
2023-08-28T16:41:25.707+01:00  INFO 26243 --- [  restartedMain] SQL dialect                              : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2023-08-28T16:41:30.263+01:00  INFO 26243 --- [  restartedMain] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2023-08-28T16:41:30.299+01:00  INFO 26243 --- [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2023-08-28T16:41:32.398+01:00  WARN 26243 --- [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2023-08-28T16:41:36.083+01:00  INFO 26243 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2023-08-28T16:41:36.183+01:00  INFO 26243 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-08-28T16:41:36.237+01:00  INFO 26243 --- [  restartedMain] InsuranceApp.mapersive.com.Application   : Started Application in 31.463 seconds (process running for 35.601)
2023-08-28T16:42:18.481+01:00  INFO 26243 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2023-08-28T16:42:18.481+01:00  INFO 26243 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2023-08-28T16:42:18.482+01:00  INFO 26243 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms

```

### 2.4. Adding the Lombok library to avoid writing BoilerPlate code.

Lombok is a convenient Java library that helps save us from writing BoilerPlate code such as getters, setters, equals/hashcode methods by using annotations like @Data, @Getter, @Setter, @EqualsAndHashCode, and more.

To activate the library, you need to add the following to your Maven pom.xml file:

- The Lombok repository
- The Maven dependency

```
<repositories>
    <repository>
        <id>projectlombok.org</id>
        <url>http://projectlombok.org/mavenrepo</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.16.2</version>
    </dependency>
</dependencies>

```

### 2.5 Déclaration of classes

Our classes is straightforward, consisting of a simple Article object (an actual JPA Entity) with the following properties:
```
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


```
```
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

}

```
These classes demonstrate how Lombok can help you reduce boilerplate code in your Java classes while working with Spring Boot and JPA.

### 2.6. Integrating Persistence with Hibernate / JPA / Spring Data JPA

Hibernate is the leading ORM (Object-Relational Mapping) framework in the Java world.
JPA (Java Persistence API) is the standard Java specification that addresses data persistence challenges.
Spring Data JPA provides an abstraction for JPA within the Spring framework. By default, Spring Data JPA uses Hibernate as the underlying JPA implementation.
#### 2.7 Declaration of the ArticleResource REST Resource
```
package InsuranceApp.mapersive.com.Controllers;

import InsuranceApp.mapersive.com.Entities.Policies;
import InsuranceApp.mapersive.com.Repositories.PoliciesRepository;
import InsuranceApp.mapersive.com.Services.PoliciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/policies")
public class PoliciesController {
    @Autowired
    PoliciesService policiesService;
    @GetMapping("/{numero}")
    public Policies getPolicie(@PathVariable String numero) {
        return policiesService.getPolicieById(numero);
    }
    @GetMapping("/All")
    public Collection<Policies> getAllPolicies() {
        return policiesService.getAllPolicies();
    }
    @GetMapping("/page")
    public Page<Policies> getPolicies(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return policiesService.getAllPolicies(PageRequest.of(page, size));
    }
    @GetMapping("/pageCus/{customerId}")
    public Page<Policies> getPoliciesByCustomer(@PathVariable int customerId, Pageable pageable) {
        return policiesService.getAllPoliciesByCustomer(customerId, pageable);
    }
    @GetMapping("/pagesort")
    public Page<Policies> getPoliciesWithSorting(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "dateOfPurchase") String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        return policiesService.getPolicies(pageable);
    }
    @GetMapping("/pagesortprem")
    public Page<Policies> getPoliciesWithSortingPrem(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "premium") String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        return policiesService.getPolicies(pageable);
    }
}
```

The `@RestController` annotation declares our class as a Controller in the Spring MVC sense, with a REST resource behavior.
The `@RequestMapping` annotation, placed at the class level, sets the base path for accessing the resource. All services within the class will inherit this path.
`@Autowired` is used to inject the previously created `Repository`.
We also find the `@RequestMapping` annotation at the method level this time. It allows us to define the exposed service more precisely.


#### 2.7.3. Verification
Now we can launch the application ($ mvn spring-boot:run) and access the URL http://localhost:8080/api/v1/policies/All in our browser to see the list of articles being displayed.
And there you have it! Our operational REST resource is up and running :-)
