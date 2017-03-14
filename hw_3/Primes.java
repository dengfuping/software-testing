package com.primes;

public class Primes {
    private static final int MAXPRIMES = 100;

    public Primes() {
    	
    }    
    
    public String printPrimes (int n) { 
        String prime = new String();
        int curPrime;  
        int numPrimes; 
        boolean isPrime; 
        int [] primes = new int [MAXPRIMES]; 
        
        primes [0] = 2; 
        numPrimes = 1; 
        curPrime = 2; 
        while (numPrimes < n) { 
            curPrime++; 
            isPrime = true; 
            for (int i = 0; i <= numPrimes-1; i++) { 
                if (curPrime%primes[i]==0) { 
                    isPrime = false; 
                    break; 
                } 
            } 
            if (isPrime) { 
                primes[numPrimes] = curPrime; 
                numPrimes++; 
            } 
        } 
        
        for (int i = 0; i <= numPrimes-1; i++) {  
            prime += primes[i] + " ";
        } 
        return prime;
    } 
}
