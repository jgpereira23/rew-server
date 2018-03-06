package models;

public enum PropType {
	HALF_DUPLEX("Half-duplex"),
	RANCH("Ranch");

    private final String name;       

    private PropType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
