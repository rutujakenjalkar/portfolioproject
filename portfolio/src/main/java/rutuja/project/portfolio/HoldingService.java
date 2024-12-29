package rutuja.project.portfolio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HoldingService {
	
	@Autowired
    private HoldingRepository holdingRepository;
	
	

   
	
	public List<Map<String, Object>> getHoldingsByPortfolioId(String portfolioId) {
        
        List<Object[]> results = holdingRepository.findHoldingsByPortfolioId(portfolioId);

       
        System.out.println("Raw query results: " + results);

        
        List<Map<String, Object>> formattedResults = new ArrayList<>();
        
        
        for (Object[] row : results) {
            Map<String, Object> record = new HashMap<>();
            record.put("securityName", row[0]);   
            record.put("securityPrice", row[1]); 
            record.put("avgCost", row[2]);        
            record.put("quantity", row[3]);       
            record.put("currency", row[4]);       
            formattedResults.add(record);
        }

      
        System.out.println("Formatted query results: " + formattedResults);

        return formattedResults;
    }



	

}
