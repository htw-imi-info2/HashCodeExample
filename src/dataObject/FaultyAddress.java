package dataObject;

import java.io.Serializable;

public class FaultyAddress implements Address {
    String street, city;
    public FaultyAddress(String street, String city) {
        this.street = street;
        this.city = city;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FaultyAddress))
        return false;
        FaultyAddress other = (FaultyAddress) obj;
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

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getCity() {
        return city;
    }
}
