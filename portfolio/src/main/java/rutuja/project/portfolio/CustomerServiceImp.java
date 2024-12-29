package rutuja.project.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService{
	
	@Autowired
	private CustomerRepository customerrespository;

	@Override
	public boolean registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		try {
		
		customerrespository.save(customer);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Customer loginUser(String email, String password) {
		// TODO Auto-generated method stub
		Customer validcustomer=customerrespository.findByEmail(email);
		
		if(validcustomer!=null && validcustomer.getPassword().equals(password))
		{
			return validcustomer;
		}
		
		return null;
	}

	@Override
	public String getIdbyName(String modelname) {
		// TODO Auto-generated method stub
		Customer validcustomer=customerrespository.findByName(modelname);
		
		if (validcustomer == null) {
	        System.out.println("No customer found for modelname: " + modelname);
	        return null; // Return null if customer is not found
	    }

	    return validcustomer.getId(); 
		
		
		
	}

	
	
	
	
}
