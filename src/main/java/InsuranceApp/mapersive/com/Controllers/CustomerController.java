package InsuranceApp.mapersive.com.Controllers;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @GetMapping("/hello")
    public String getCompteById() {
        return "Hello From Mapvirse";
    }
}
