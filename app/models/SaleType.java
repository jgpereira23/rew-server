package models;

public enum SaleType {
	BY_OWNER ("by owner"),
	BANK_OWNED_FORECLOSURE ("bank-owned foreclosure");
	
	private final String name;       

    private SaleType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
