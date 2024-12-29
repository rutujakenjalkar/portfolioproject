package rutuja.project.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class addholdingsController {
	
	@GetMapping("/addholdings")
    public String showcreatePortfolioPage() {
		
        return "addholdings"; // Return the profile page initially
    }
	

}
