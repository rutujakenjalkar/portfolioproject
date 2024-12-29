package rutuja.project.portfolio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "security")
public class Security {

	@Id
    @Column(name = "security_id", length = 10)
    private String securityId;

    @Column(name = "name")
    private String name;

    @Column(name = "price",length=30)
    private Integer price;

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Security [securityId=" + securityId + ", name=" + name + ", price=" + price + "]";
	}

	public Security(String securityId, String name, Integer price) {
		super();
		this.securityId = securityId;
		this.name = name;
		this.price = price;
	}
    
    
}
