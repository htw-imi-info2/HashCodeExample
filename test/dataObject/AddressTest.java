package dataObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    Address a1, a2, a3;

    @BeforeEach
    void setUp() {
         a1 = new Address("Wilhelminenhofstr. 75a", "Berlin");
         a2 = new Address("Wilhelminenhofstr. 75a", "Berlin");
         a3 = new Address("Treskowallee 8", "Berlin");

    }
    @Test
    public void testEqualsTrue(){
        assertTrue(a1.equals(a2));
    }
    @Test
    public void testEqualsFalse(){
        assertFalse(a1.equals(a3));
    }
}