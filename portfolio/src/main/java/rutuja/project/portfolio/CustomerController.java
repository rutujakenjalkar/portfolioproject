package rutuja.project.portfolio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerrepository;
	
	
	public CustomerController(CustomerRepository customerrepository) {
		super();
		this.customerrepository = customerrepository;
	}

	
	@GetMapping
	public List<Customer> getAllStudents() {
        return customerrepository.findAll();
    }

	@GetMapping("/details")
	public String opencustomerdetails(@RequestParam("modelid") String modelid,Model model)
	{
		 Customer customer = customerrepository.findById(modelid).orElse(null);
		
		model.addAttribute("customer",customer);
		
		return "customerdetails";
	}
	
	@PostMapping("/update")
	public String updatecustomerdetails(
			@RequestParam("modelid") String modelid,
			@RequestParam("name") String name,
	        @RequestParam("email") String email,
	        @RequestParam("address") String address,
	        @RequestParam("mobile_no") String mobile_no,
	            Model model)
	{
		Customer customer = customerrepository.findById(modelid).orElse(null);
		
		if (customer == null) {
		    model.addAttribute("message", "Customer not found!");
		    return "customerdetails";  // or any error page
		}
		
		customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setMobile_no(mobile_no);

        customerrepository.save(customer);
        
        model.addAttribute("customer",customer);
        model.addAttribute("message", "Customer details updated successfully!");
        
        
		return "customerdetails";
	}


}
