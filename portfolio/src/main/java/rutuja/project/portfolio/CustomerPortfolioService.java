package rutuja.project.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerPortfolioService {

	 @Autowired 
	 private CustomerRepository customerrepository;
	 
	
    @Autowired 
    private CustomerPortfolioRepository customerPortfolioRepository;
    
    @Autowired
    public CustomerPortfolioService(CustomerPortfolioRepository customerPortfolioRepository) {
        this.customerPortfolioRepository = customerPortfolioRepository;
    }

    public List<CustomerPortfolio> getPortfoliosByCustomerId(String customerId) {
    	
    	System.out.println("Customer ID: " + customerId);  
    	List<CustomerPortfolio> portfolios = customerPortfolioRepository.findPortfoliosByCustomerId(customerId);
        System.out.println("Portfolios retrieved from database: " + portfolios);
        return portfolios;
    }
    
    public CustomerPortfolio saveCustomerPortfolio(CustomerPortfolio customerPortfolio) {
        return customerPortfolioRepository.save(customerPortfolio);
    }
    
  
    
}

