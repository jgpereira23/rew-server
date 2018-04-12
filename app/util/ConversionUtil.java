package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import models.PropType;
import models.SaleType;
import models.entity.Listing;
import models.payload.AddressVO;
import models.payload.ListingVO;

public class ConversionUtil {
	
	private static final String DB_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	private static final String UI_DATE_FORMAT = "MMMMM dd yyyy";
	
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
    	listingVO.setMarketDuration(toMarketDuration(listing.market_date));
    	listingVO.setMarketDuration(toMarketDate(listing.market_date));
    	listingVO.setPrice(listing.price);
    	listingVO.setPropType(PropType.valueOf(listing.property_type).toString());
    	listingVO.setSaleType(SaleType.valueOf(listing.sale_type).toString());
    	listingVO.setYrBuilt(listing.year_built);
		listingVO.setAddress(address);
		return listingVO;
	}
	
	public static String toMarketDate(String marketDate) {
		SimpleDateFormat dbFormat = getDBDateFormat();
		SimpleDateFormat uiFormat = getUIDateFormat();
		try {
			Date date = dbFormat.parse(marketDate);

			return uiFormat.format(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String toMarketDuration(String marketDate){
		StringBuilder marketDuration = new StringBuilder();
		SimpleDateFormat dateFormat = getDBDateFormat();
		Date date;
		try {
			date = dateFormat.parse(marketDate);
		} catch (ParseException e) {
			return null;
		}
		
		Date currentDate = new Date();
		long diffInMillies = Math.abs(currentDate.getTime() - date.getTime());
		long days = TimeUnit.MILLISECONDS.toDays(diffInMillies);				
		long years = days/365;
		long months = days/30 - years*12;
		long weeks = days/7 - months*4 - years*12;

		if(years>1){
			marketDuration.append(years);
			marketDuration.append(" years");
			months -= years*12;
			if(months>1){
				marketDuration.append(" and");
				marketDuration.append(months);
				marketDuration.append(" months");
			}else if(months >0){
				marketDuration.append(" and");
				marketDuration.append(months);
				marketDuration.append(" month");
			}
		}else if(years >0){
			months -= 12;
			if(months>1){
				marketDuration.append(" and");
				marketDuration.append(months);
				marketDuration.append(" months");
			}else if(months >0){
				marketDuration.append(" and");
				marketDuration.append(months);
				marketDuration.append(" month");
			}
		}else{
			if(months>1){
				marketDuration.append(months);
				marketDuration.append(" months");
				if(weeks >0){
					marketDuration.append(" and");
					marketDuration.append(weeks);
					marketDuration.append(" weeks");
				}
			}else if(months >0){
				marketDuration.append("A month");
				if(weeks >1){
					marketDuration.append(" and");
					marketDuration.append(weeks);
					marketDuration.append(" weeks");
				}else if(weeks >0){
					marketDuration.append(" and a week");
				}
			}else{
				if(weeks >1){
					marketDuration.append(weeks);
					marketDuration.append(" weeks");
				}else if(weeks >0){
					marketDuration.append("A week");
				}
			}
		}
		if(marketDuration.length()==0){
			if(days > 1){
				marketDuration.append(days);
				marketDuration.append(" days");
			}else{
				marketDuration.append("A day");
			}
		}
		marketDuration.append(" ago");
		return marketDuration.toString();
	}
	
	public static SimpleDateFormat getDBDateFormat(){
		return new SimpleDateFormat(DB_DATE_FORMAT);
	}
	
	public static SimpleDateFormat getUIDateFormat() {
		return new SimpleDateFormat(UI_DATE_FORMAT);
	}
}
