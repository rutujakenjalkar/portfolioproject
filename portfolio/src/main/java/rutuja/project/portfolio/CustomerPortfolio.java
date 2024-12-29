package rutuja.project.portfolio;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_portfolio")
public class CustomerPortfolio {

  
	@Id
	@Column(name="portfolio_id",nullable=false,length=10)
	private String portfolioId;
	
	
	@Column(name = "customer_id", nullable=false,length=10)
	private String customerId;
	
	
	@Column(name = "ownership")
	private Integer ownership;


	public String getPortfolioId() {
		return portfolioId;
	}


	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public Integer getOwnership() {
		return ownership;
	}


	public void setOwnership(Integer ownership) {
		this.ownership = ownership;
	}


	public CustomerPortfolio(String portfolioId, String customerId, Integer ownership) {
		super();
		this.portfolioId = portfolioId;
		this.customerId = customerId;
		this.ownership = ownership;
	}


	
	
	@Override
	public String toString() {
		return "CustomerPortfolio [portfolioId=" + portfolioId + ", customerId=" + customerId + ", ownership="
				+ ownership + "]";
	}


	public CustomerPortfolio() {
		
	}


	
	
	
}
