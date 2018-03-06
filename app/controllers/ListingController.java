package controllers;

import java.util.ArrayList;
import java.util.List;

import models.PropType;
import models.SaleType;
import models.entity.Listing;
import models.payload.ActiveListingsResponseVO;
import models.payload.AddressVO;
import models.payload.ListingVO;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.ConversionUtil;
import views.html.index;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ListingController extends Controller {

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
    	AddressVO address = new AddressVO();
    	address.setAptNum("5A");
    	address.setCity("Woodbridge");
    	address.setState("NJ");
    	address.setStreetName("Olive");
    	address.setStreetNum("535");
    	address.setStreetType("Place");
    	address.setZip("07095");
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
    	List<Listing> listings = Listing.findAllActiveListings();
    	for(Listing listing : listings){
        	listingsVO.add(ConversionUtil.toListingVO(listing) );
    	}
		activeListingsResponse.setListings(listingsVO );
    	
	    return ok(Json.toJson(activeListingsResponse));
    }
    
    public Result upsertListing() {
		return null;
    	
    }
    
    public Result removeListing() {
        return ok(index.render("Your new application is ready."));
    }
    
    public Result retrieveListing() {
        return ok(index.render("Your new application is ready."));
    }
    public static Result r() {
    	return ok("Success!");
    }

}
