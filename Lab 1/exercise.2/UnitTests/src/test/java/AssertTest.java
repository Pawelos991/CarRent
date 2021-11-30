/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class AssertTest {

    @Test
    public void testControlFlow() {
        if ((2 + 2) != 4) {
            assert false : "Adding error!";
            //fail("Adding error!");
            //assertTrue(false, "Adding error!");
            //assertFalse(true, "Adding error!");        
        }
    }

    @Test
    public void testEquals() {
        int x = 4;
        int y = 2 + 2;
        float z = 4.001f;
        assertEquals(x, y, "Variable values ​​are not the same!");
        assertEquals(x, z, 0.01, "Variable values ​​differ by more than 0.01!");
    }

    @Test
    public void testArrayEquals() {
        int tab1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int tab2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(tab1, tab2, "Collections values ​​in both arrays are not identical!");
    }

    @Test
    public void testReferences() {
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = null;

        assertNotSame(object1, object2, "References point to the same object!");
        assertNotSame(object1, object3, "References point to the same object!");
        assertNotNull(object1, "Reference to null!");
        assertNotNull(object2, "Reference to null!!");
        assertNull(object3, "Reference not null!");
        object3 = object1;
        assertSame(object1, object3, "References do not indicate the same object!");
    }

}
