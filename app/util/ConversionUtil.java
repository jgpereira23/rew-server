package util;

import models.PropType;
import models.SaleType;
import models.entity.Listing;
import models.payload.AddressVO;
import models.payload.ListingVO;

public class ConversionUtil {
	//convert a listing into a listingVO
	public static ListingVO toListingVO(Listing listing){
		ListingVO listingVO = new ListingVO();
    	//1 to 1 transfer values to the listingVO
		AddressVO address = new AddressVO();
    	address.setAptNum(listing.apt_number);
    	address.setCity(listing.city);
    	address.setState(listing.state);
    	address.setStreetName(listing.street_name);
    	address.setStreetNum(listing.street_number);
    	address.setStreetType(listing.street_type);
    	address.setZip(String.valueOf(listing.zip_code));
    	
    	listingVO.setAddress(address);
    	listingVO.setBasementFinished(listing.is_active);
    	listingVO.setBathrooms(listing.bathrooms);
    	listingVO.setBedrooms(listing.bedrooms);
    	listingVO.setHomeSqFt(listing.home_square_feet);
    	listingVO.setLandSqFt(listing.land_square_feet);
    	listingVO.setMarketDuration(listing.market_date);
    	listingVO.setPrice(listing.price);
    	listingVO.setPropType(PropType.valueOf(listing.property_type));
    	listingVO.setSaleType(SaleType.valueOf(listing.sale_type));
    	listingVO.setYrBuilt(listing.year_built);
		listingVO.setAddress(address);
		
		return listingVO;
	}
}
