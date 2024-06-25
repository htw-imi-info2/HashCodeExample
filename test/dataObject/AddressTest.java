package dataObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    static FaultyAddress  fa1 = new FaultyAddress("Wilhelminenhofstr. 75a", "Berlin");
    static FaultyAddress  fa2 = new FaultyAddress("Wilhelminenhofstr. 75a", "Berlin");
    static FaultyAddress  fa3 = new FaultyAddress("Treskowallee 8", "Berlin");
    static FixedAddress a1 = new FixedAddress("Wilhelminenhofstr. 75a", "Berlin");
    static FixedAddress a2 = new FixedAddress("Wilhelminenhofstr. 75a", "Berlin");
    static FixedAddress a3 = new FixedAddress("Treskowallee 8", "Berlin");

    @ParameterizedTest
    @MethodSource("testEqualsExamples")
    public void testEquals(Boolean result, Address a1, Address a2, String message, boolean expectFailure){
        assertEquals(result,a1.equals(a2), message);
    }
    static Object[][] testEqualsExamples(){
        return new Object[][]{
                {true, fa1,fa2,"faulty address equal", true},
                {true, a1,a2,"fixed address equal", false},
                {false, fa1,fa3,"faulty address not equal", false},
                {false, a1,a3,"fixed address not equal",false},
        };
    }

    @ParameterizedTest
    @MethodSource("testEqualsExamples")

    public void useHashSet(Boolean result, Address a1, Address a2, String message, boolean expectFailure) {
        Set<Address> set = new HashSet<>();
        set.add(a1);
        Boolean actual = set.contains(a2);
        if (expectFailure){
            message = "Expected to Fail: " + message;
            actual = !actual;
        }
        assertEquals(result, actual);
    }

}