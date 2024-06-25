package dataObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashSetFailure {
    Address a1, a2, a3;

    @BeforeEach
    void setUp() {
        a1 = new Address("Wilhelminenhofstr. 75a", "Berlin");
        a2 = new Address("Wilhelminenhofstr. 75a", "Berlin");
        a3 = new Address("Treskowallee 8", "Berlin");

    }
    @Test
    public void useHashSetIdenticalObjects() {
        Set<Address> set = new HashSet<>();
        set.add(a1);
        assertTrue(set.contains(a1));
    }

    @Test
    public void useHashSetEqualObjects() {
        Set<Address> set = new HashSet<>();
        set.add(a1);
        // why does this fail?!
        assertTrue(set.contains(a2));
    }

    @Test
    public void equalObjectIsAddedTwice() {
        Set<Address> set = new HashSet<>();
        set.add(a1);
        // why does this fail?!
        assertTrue(set.contains(a2));
    }
}
