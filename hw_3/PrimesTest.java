package com.primes;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrimesTest {
	private Primes primes;
    @Before
    public void setUp() throws Exception {
    	primes = new Primes();
    }

    @After
    public void tearDown() throws Exception {
    	
    }

    @Test
    public void test1() {
        assertEquals("2 3 5 ", primes.printPrimes(3));
    }
    
    @Test
    public void test2() {
        assertEquals("2 3 5 7 11 ", primes.printPrimes(5));
    }

}
