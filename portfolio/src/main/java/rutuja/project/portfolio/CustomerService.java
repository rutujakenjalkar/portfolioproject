package rutuja.project.portfolio;

public interface CustomerService {
	
	public boolean registerCustomer(Customer customer);
    
	public Customer loginUser(String email,String password);
	
	public String getIdbyName(String modelname);
}
