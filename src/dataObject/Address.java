package dataObject;

public class Address {
    String street, city;
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Address))
        return false;
        Address other = (Address) obj;
        if (!fieldsEqual(this.street, other.street))
            return false;
        if (!fieldsEqual(this.city, other.city))
            return false;
        return true;

    }

    private static boolean fieldsEqual(String thisValue, String otherValue) {
        if (thisValue == null){
            if (otherValue != null)
                return false;
        } else {
            if (!thisValue.equals(otherValue))
                return false;
        }
        return true;
    }
}
