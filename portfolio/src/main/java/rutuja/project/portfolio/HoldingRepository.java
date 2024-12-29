package rutuja.project.portfolio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HoldingRepository extends JpaRepository<Holding,HoldingKey> {
	
	@Query(value = "SELECT s.name AS securityName, s.price AS securityPrice, " +
            "h.avg_cost AS avgCost, h.quantity AS quantity, h.currency AS currency " +
            "FROM security s " +
            "JOIN holding h ON s.security_id = h.security_id " +
            "WHERE h.portfolio_id = :portfolioId", nativeQuery = true)
     List<Object[]> findHoldingsByPortfolioId(@Param("portfolioId") String portfolioId);
     
     

}
