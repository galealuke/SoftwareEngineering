/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luke
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int a = 3;
        int b = 6;
        Calculator instance = new Calculator();
        int expResult = 9;
        int result = instance.add(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of subtract method, of class Calculator.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        int a = 10;
        int b = 6;
        Calculator instance = new Calculator();
        int expResult = 4;
        int result = instance.subtract(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Calculator.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        int a = 2;
        int b = 4;
        Calculator instance = new Calculator();
        int expResult = 8;
        int result = instance.multiply(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        int a = 10;
        int b = 5;
        Calculator instance = new Calculator();
        int expResult = 2;
        int result = instance.divide(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
