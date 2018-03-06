package models.payload;

import java.util.List;

public class ActiveListingsResponseVO {
	
	private List<ListingVO> listings;

	public List<ListingVO> getListings() {
		return listings;
	}

	public void setListings(List<ListingVO> listings) {
		this.listings = listings;
	}
	
}
