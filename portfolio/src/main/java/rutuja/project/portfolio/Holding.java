package rutuja.project.portfolio;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "holding")
public class Holding {
	@EmbeddedId
    private HoldingKey id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "avg_cost", precision = 10, scale = 2)
    private BigDecimal avgCost;

    @Column(name = "currency", length = 3)
    private String currency;

	public Holding(HoldingKey id, Integer quantity, BigDecimal avgCost, String currency) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.avgCost = avgCost;
		this.currency = currency;
	}

	public HoldingKey getId() {
		return id;
	}

	public void setId(HoldingKey id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(BigDecimal avgCost) {
		this.avgCost = avgCost;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Holding [id=" + id + ", quantity=" + quantity + ", avgCost=" + avgCost + ", currency=" + currency + "]";
	}
    
    
    
}
