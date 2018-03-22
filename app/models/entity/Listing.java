package models.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import models.payload.AddressVO;

@Entity
public class Listing extends Model {

	@Id
	@GeneratedValue
	public Long id;
	
	@Column(name="created_at", updatable = false)
	@CreatedTimestamp
	public Date createdAt;
	
	@Column(name = "updated_at")
	@UpdatedTimestamp
	public Date updatedAt;

	@Column(length = 500, nullable = false)
	@NotNull
	@Size(max = 500)
	public String street_name;
	
	@Column(length = 11, nullable = false)
	@NotNull
	public int street_number;
	
	@Column(length = 2, nullable = false)
	@NotNull
	@Size(max = 5)
	public String street_type;
	
	@Column(length = 15, nullable = false)
	@NotNull
	public String apt_number;
	
	@Column(length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	public String city;
	
	@Column(length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	public String state;
	
	@Column(length = 11, nullable = false)
	@NotNull
	public String zip_code;
	
	@Column(columnDefinition = "TEXT")
	@NotNull
	public String description;

	@Column(nullable = false)
	@NotNull
	public double bedrooms;
	
	@Column(nullable = false)
	@NotNull
	public double bathrooms;
	
	@Column(length = 11, nullable = false)
	@NotNull
	public int home_square_feet;
	
	@Column(length = 11,nullable = false)
	@NotNull
	public int land_square_feet;
	
	@Column(length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	public String sale_type;
	
	@Column(length = 11, nullable = false)
	@NotNull
	public int year_built;
	
	@Column(nullable = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public String market_date;
	
	@Column(length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	public String property_type;
	
	public boolean finished_basement;
	
	@Column(nullable = false)
	@NotNull
	public double price;
	
	public boolean is_active;

	public static final Finder<Long, Listing> find = new Finder<Long, Listing>(Long.class, Listing.class);
	
	public static List<Listing> findAllActiveListings() {
		return find.where().eq("is_active", true).findList();
	}
	
	public static Listing findByID(Long id){
		return find.byId(id);
	}
	
	public static Listing findByAddress(AddressVO address){
		return find.where()
				.eq("street_number", address.getStreetNum())
				.and().eq("street_name", address.getStreetName())
				.and().eq("street_type", address.getStreetType())
				.and().eq("city", address.getCity())
				.and().eq("state", address.getState())
				.and().eq("zip_code", address.getZip()).findUnique();
	}
}
