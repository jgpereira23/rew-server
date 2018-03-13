package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import models.PropType;
import models.SaleType;
import models.entity.Listing;
import models.payload.ActiveListingsResponseVO;
import models.payload.AddressVO;
import models.payload.ListingVO;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.ConversionUtil;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ListingController extends Controller {
	
	@Inject
	FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result retrieveActiveListings() {
    	ActiveListingsResponseVO activeListingsResponse = new  ActiveListingsResponseVO();
    	List<ListingVO> listingsVO = new ArrayList<ListingVO>();
    	ListingVO listingVO = new ListingVO();
    	//configure address obj
    	AddressVO address = new AddressVO();
    	address.setAptNum("5A");
    	address.setCity("Woodbridge");
    	address.setState("NJ");
    	address.setStreetName("Olive");
    	address.setStreetNum(535);
    	address.setStreetType("Place");
    	address.setZip("07095");
    	//create listing object
    	listingVO.setAddress(address);
    	listingVO.setBasementFinished(true);
    	listingVO.setBathrooms(2.0);
    	listingVO.setBedrooms(2);
    	listingVO.setHomeSqFt(3250);
    	listingVO.setLandSqFt(4500);
    	listingVO.setMarketDuration("3 months");
    	listingVO.setPrice(200000.00);
    	listingVO.setPropType(PropType.HALF_DUPLEX);
    	listingVO.setSaleType(SaleType.BY_OWNER);
    	listingVO.setYrBuilt(1953);
    	//request for active listings and save to a list
    	List<Listing> listings = Listing.findAllActiveListings();
    	//iterate thru list and add it to our listingsVO list
    	for(Listing listing : listings){
        	listingsVO.add(ConversionUtil.toListingVO(listing) );
    	}
    	
		activeListingsResponse.setListings(listingsVO );
    	
	    return ok(Json.toJson(activeListingsResponse));
    }
    
    public Result create() {
    	//create listing obj from the values of the form
    	//Listing newlisting = formFactory.form(Listing.class).bindFromRequest().get();
    	Form<Listing> listingForm = formFactory.form(Listing.class).bindFromRequest();
    	/*
    	if(listingForm.hasErrors()){
    		return badRequest();
    	}*/
    	
    	//grab values from new listing and save it to address vo
    	/*
    	AddressVO address = new AddressVO();
    	address.setStreetName(newlisting.street_name);
    	address.setStreetNum(newlisting.street_number);
    	address.setStreetType(newlisting.street_type);
    	address.setAptNum(newlisting.apt_number);
    	address.setCity(newlisting.city);
    	address.setState(newlisting.state);
    	address.setZip(newlisting.zip_code);
    	*/
    	/*Listing existingListing = Listing.findByAddress(address);
    	if(existingListing != null){
    		
    	}*/
    	Listing newListing = listingForm.get();
    	newListing.save();
    	return ok("Listing Saved!");
    }
    
    public Result delete(Long id) {
    	return TODO;
    }
    
    public Result read(Long id) {
    	return TODO;
    }
    
    public Result update(Long id) {
    	return TODO;
    }
}
