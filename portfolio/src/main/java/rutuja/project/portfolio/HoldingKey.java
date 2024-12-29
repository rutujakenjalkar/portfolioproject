package rutuja.project.portfolio;

import java.util.Objects;

import jakarta.persistence.Column;

import java.io.Serializable;

public class HoldingKey implements Serializable{

	
	@Column(name = "security_id", length = 10)
    private String securityId;

    @Column(name = "portfolio_id", length = 10)
    private String portfolioId;

	public HoldingKey(String securityId, String portfolioId) {
		super();
		this.securityId = securityId;
		this.portfolioId = portfolioId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}

	@Override
	public String toString() {
		return "HoldingKey [securityId=" + securityId + ", portfolioId=" + portfolioId + "]";
	}
    
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoldingKey that = (HoldingKey) o;
        return Objects.equals(securityId, that.securityId) && Objects.equals(portfolioId, that.portfolioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(securityId, portfolioId);
    }
	
}
