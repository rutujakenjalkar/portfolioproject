package rutuja.project.portfolio;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CustomerPortfolioId implements Serializable {

	@Column(name = "customer_id")
    private String customerId;
	
	@Column(name = "portfolio_id")
    private String portfolioId;

    // Default constructor
    public CustomerPortfolioId() {}

    // Constructor
    public CustomerPortfolioId(String customerId, String portfolioId) {
        this.customerId = customerId;
        this.portfolioId = portfolioId;
    }

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerPortfolioId that = (CustomerPortfolioId) o;
        return customerId.equals(that.customerId) && portfolioId.equals(that.portfolioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, portfolioId);
    }
}
