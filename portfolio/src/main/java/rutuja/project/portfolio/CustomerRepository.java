package rutuja.project.portfolio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import rutuja.project.portfolio.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String> {
	
	Customer findByCustomerId(String customerId);
	
    Customer findByEmail(String email);

    Customer findByName(String name);
    
    
   
    
}
