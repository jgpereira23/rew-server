package models.payload;

import models.PropType;
import models.SaleType;

public class ListingVO {
	
	private AddressVO address;
	private double price;
	private double bedrooms;
	private int landSqFt;
	private double bathrooms;
	private int homeSqFt;
	private String saleType;
	private int yrBuilt;
	private String marketDuration;
	private String marketDate;
	private boolean basementFinished;
	private String propType;
	
	public AddressVO getAddress() {
		return address;
	}
	public void setAddress(AddressVO address) {
		this.address = address;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(double bedrooms) {
		this.bedrooms = bedrooms;
	}
	public int getLandSqFt() {
		return landSqFt;
	}
	public void setLandSqFt(int landSqFt) {
		this.landSqFt = landSqFt;
	}
	public double getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(double bathrooms) {
		this.bathrooms = bathrooms;
	}
	public int getHomeSqFt() {
		return homeSqFt;
	}
	public void setHomeSqFt(int homeSqFt) {
		this.homeSqFt = homeSqFt;
	}
	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	public int getYrBuilt() {
		return yrBuilt;
	}
	public void setYrBuilt(int yrBuilt) {
		this.yrBuilt = yrBuilt;
	}
	public String getMarketDuration() {
		return marketDuration;
	}
	public void setMarketDuration(String marketDuration) {
		this.marketDuration = marketDuration;
	}
	public String getMarketDate() {
		return marketDate;
	}
	public void setMarketDate(String marketDate) {
		this.marketDate = marketDate;
	}
	public boolean isBasementFinished() {
		return basementFinished;
	}
	public void setBasementFinished(boolean basementFinished) {
		this.basementFinished = basementFinished;
	}
	public String getPropType() {
		return propType;
	}
	public void setPropType(String propType) {
		this.propType = propType;
	}
}
