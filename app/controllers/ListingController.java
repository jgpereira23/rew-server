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
    	List<ListingVO> listingsVO = new ArrayList<>();
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
    	Form<Listing> listingForm = formFactory.form(Listing.class).bindFromRequest();
    	if(listingForm.hasErrors()){
    		return badRequest("Form has Errors");
    	}
    	Listing newListing = listingForm.get();
    	
    	//grab values from new listing and save it to address vo
    	AddressVO address = new AddressVO();
    	address.setStreetName(newListing.street_name);
    	address.setStreetNum(newListing.street_number);
    	address.setStreetType(newListing.street_type);
    	address.setAptNum(newListing.apt_number);
    	address.setCity(newListing.city);
    	address.setState(newListing.state);
    	address.setZip(newListing.zip_code);
    	
    	Listing existingListing = Listing.findByAddress(address);
    	if(existingListing != null){
    		return badRequest("This Listing already exists");
    	}   
    	
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
