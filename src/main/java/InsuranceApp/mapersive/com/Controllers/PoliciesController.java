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
