package rutuja.project.portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class PortfolioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String createPortfolio(String customerId, String portfolioId, String pname, int ownership) {
    	 final String[] result = new String[1];

       
        jdbcTemplate.execute((Connection connection) -> {
            CallableStatement callableStatement = null;

            try {
                
                callableStatement = connection.prepareCall("{CALL create_portfolio(?, ?, ?, ?, ?)}");

               
                callableStatement.setString(1, customerId);
                callableStatement.setString(2, portfolioId);
                callableStatement.setString(3, pname);
                callableStatement.setInt(4, ownership);

                
                callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);

               
                callableStatement.execute();

                
                result[0] = callableStatement.getString(5);
            } finally {
                if (callableStatement != null) {
                    callableStatement.close();
                }
            }
            return null; // jdbcTemplate.execute requires a return
        });

        return result[0];
    }
    
    
    public String deletePortfolio(String portfolioId) {
    	
    	final String[] resultMessage = new String[1];
    	
    	 jdbcTemplate.execute((Connection connection) -> {
             CallableStatement callableStatement = null;

             try {
                 
                 callableStatement = connection.prepareCall("{CALL delete_portfolio(?, ?)}");

                
               
                 callableStatement.setString(1, portfolioId);
               
                 
                 callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);

                
                 callableStatement.execute();

                 
                 resultMessage[0] = callableStatement.getString(2);
             } finally {
                 if (callableStatement != null) {
                     callableStatement.close();
                 }
             }
             return null; // jdbcTemplate.execute requires a return
         });

         return resultMessage[0];
    }
}
