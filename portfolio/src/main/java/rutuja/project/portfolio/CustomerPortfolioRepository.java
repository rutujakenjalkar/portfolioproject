package rutuja.project.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerPortfolioRepository extends JpaRepository<CustomerPortfolio, CustomerPortfolioId> {

    @Query("SELECT p FROM CustomerPortfolio p WHERE p.customerId = :modelid")
    List<CustomerPortfolio> findPortfoliosByCustomerId(@Param("modelid") String modelid);

}
