package models;

public enum SaleType {
	BY_OWNER ("By owner"),
	BANK_OWNED_FORECLOSURE ("Bank-owned foreclore");
	
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
