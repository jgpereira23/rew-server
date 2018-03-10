package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Constraint;

import controllers.Application.SignUp;
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
    	address.setZip(07095);
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
    	Listing newlisting = formFactory.form(Listing.class).bindFromRequest().get();
    	Listing existingListing = Listing.findByID(addressov);
    	return ok("Success!");
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
