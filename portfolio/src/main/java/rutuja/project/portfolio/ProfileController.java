package rutuja.project.portfolio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private HoldingService holdingservice;
	
	@Autowired
	private CustomerService customerservice;
	
	 @Autowired
	    private CustomerPortfolioService customerPortfolioService;

	
	
	@GetMapping("/profile")
    public String showProfilePage(@RequestParam("modelname") String modelname, Model model) {

		model.addAttribute("modelname", modelname);
		
        return "profile"; // Return the profile page initially
    }

    @PostMapping("/holdings")
    public String getHoldings(@RequestParam("portfolioId") String portfolioId,@RequestParam("modelname")String  modelname, Model model) {
    	
    	
    	String modelid=customerservice.getIdbyName(modelname);
    	
    	if (modelid == null) {
            model.addAttribute("error", "Customer not found with name: " + modelname);
            return "profile"; // Stay on the same page and show the error
        }
    	
    	model.addAttribute("modelid",modelid);
    	 model.addAttribute("modelname", modelname);
    	model.addAttribute("portfolioId", portfolioId);
    	
    	// Fetch holdings based on the portfolioId   	
        List<Map<String, Object>> holdings = holdingservice.getHoldingsByPortfolioId(portfolioId);
        
        if (holdings != null && !holdings.isEmpty()) {
            model.addAttribute("holdings", holdings);
        } else {
            model.addAttribute("holdings", null); // Empty list if no holdings
        }

        
        
        return "profile";
    }
	
    
    @PostMapping("/viewportfolios")
    public String viewPortfolio(@RequestParam("modelname")String  modelname,@RequestParam("modelid") String modelid, Model model) {
        // Retrieve portfolios based on customerId
        List<CustomerPortfolio> portfolios = customerPortfolioService.getPortfoliosByCustomerId(modelid);
        
        
        model.addAttribute("portfolios", portfolios);
        model.addAttribute("modelid", modelid);
        model.addAttribute("modelname", modelname);
        
        System.out.println("modelid: " + modelid);
        System.out.println("modelname: " + modelname);

     

        System.out.println("Retrieved portfolios: " + portfolios);

        // Return the same page name (e.g., portfolio.jsp)
        return "profile";  // Your JSP page that shows the portfolios
    }
	
	
	
	
}
