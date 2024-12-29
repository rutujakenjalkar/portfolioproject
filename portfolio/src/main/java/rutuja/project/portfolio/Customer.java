package rutuja.project.portfolio;

import java.util.ArrayList;
import java.util.UUID;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	
	@Id
	@Column(name="customer_id",nullable=false,length=10)
	private String customerId;
	
	
	@Column(name = "name", nullable=false,length=255)
	private String name;
	
	
	@Column(name = "email", length=255)
	private String email;
	
	@Column(name = "address",length=255)
	private String address;
	

	@Column(name = "mobile_no",length=255)
	private String mobile_no;
	
	@Column(name="password",length=255,nullable=false)
	private String password;
	
	
    public Customer() {
    }

	public Customer(String id, String name, String email, String address, String mobile_no,String password) {
		super();
		this.customerId = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobile_no = mobile_no;
		this.password=password;
		}

	
	@PrePersist
    private void generateCustomerId() {
        if (this.customerId == null || this.customerId.isEmpty()) {
            this.customerId = UUID.randomUUID().toString().substring(0, 10);; // Generates a unique ID
        }
    }
	

	public String getId() {
		return customerId;
	}

	public void setId(String id) {
		this.customerId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", mobile_no=" + mobile_no + ", password=" + password + "]";
	}
	
	
	
	
	

}
