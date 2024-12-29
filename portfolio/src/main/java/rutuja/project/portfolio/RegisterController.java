package rutuja.project.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/register")
	public String openregister(Model model)
	{
		model.addAttribute("customer",new Customer());
		return "register";
	}
	
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("customer")Customer customer,Model model)
	{
		boolean status=customerservice.registerCustomer(customer);
		if(status)
		{
			model.addAttribute("successmsg","customer registered succesfully");
		}
		else
		{
			model.addAttribute("errormsg","customer not registered");
		}
		return "register";
		
	}
	
	 
	//Login Page
	
	@GetMapping("/loginpage")
	public String OpenLoginPage(Model model)
	{
		model.addAttribute("customer",new Customer());
		return "login";
	}
	
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("customer")Customer customer,Model model)
	{
		
		Customer validcustomer =customerservice.loginUser(customer.getEmail(),customer.getPassword());
		
		if(validcustomer!= null)
		{
			model.addAttribute("modelname",validcustomer.getName());
		model.addAttribute("modelid",validcustomer.getId());
			return "profile";
		}
		else
		{
			model.addAttribute("errormsg","email id and pasword didnt match");
			return "login";
		}
		
	}
	
}
