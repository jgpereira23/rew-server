package models.entity;

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

@Entity
public class Listing extends Model {

	@Id
	@GeneratedValue
	public Long id;

	@Column(length = 500, nullable = false)
	@NotNull
	@Size(max = 500)
	public String street_name;
	
	@Column(length = 11, nullable = false)
	@NotNull
	@Size(max = 11)
	public int street_number;
	
	@Column(length = 2, nullable = false)
	@NotNull
	@Size(max = 2)
	public String street_type;
	
	@Column(length = 15, nullable = false)
	@NotNull
	@Size(max = 15)
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
	@Size(max = 11)
	public int zip_code;
	
	@Column(columnDefinition = "TEXT")
	@NotNull
	public String description;

	@Column(length = 11, nullable = false)
	@NotNull
	@Size(max = 11)
	public double bedrooms;
	
	@Column(length = 11, nullable = false)
	@NotNull
	@Size(max = 11)
	public double bathrooms;
	
	@Column(length = 11, nullable = false)
	@NotNull
	@Size(max = 11)
	public int home_square_feet;
	
	@Column(length = 11, nullable = false)
	@NotNull
	@Size(max = 11)
	public int land_square_feet;
	
	@Column(length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	public String sale_type;
	
	@Column(length = 11, nullable = false)
	@NotNull
	@Size(max = 11)
	public int year_built;
	
	@Column(length = 20, nullable = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public String market_date;
	
	@Column(length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	public String property_type;
	
	public boolean finished_basement;
	
	@Column(length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	public double price;
	
	public boolean is_active;

	public static final Finder<Long, Listing> find = new Finder<Long, Listing>(Long.class, Listing.class);
	
	public static List<Listing> findAllActiveListings() {
		return find.where().eq("is_active", true).findList();
	}

}
