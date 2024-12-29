package rutuja.project.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class PortfolioController {
	
	@Autowired
	private PortfolioService portfolioservice;
	
	
	@GetMapping("/portfolio")
    public String showcreatePortfolioPage() {
		
        return "portfolio"; // Return the profile page initially
    }
	
	@PostMapping("/portfolio/create")
	public String createPortfolio(
			@RequestParam String customerId,
			@RequestParam String portfolioId,
			@RequestParam String pname,
			@RequestParam int owner_ship,
			Model model)
	{
		String result = portfolioservice.createPortfolio(customerId, portfolioId, pname, owner_ship);

		 model.addAttribute("result", result);
	     return "portfolio";
		
	}
	
	@PostMapping("/portfolio/delete")
	public String deletePortfolio(
			@RequestParam String portfolioId,
			Model model)
	{
		String result = portfolioservice.deletePortfolio(portfolioId);

		 model.addAttribute("result", result);
	     return "portfolio";
		
	}
	
	

}
