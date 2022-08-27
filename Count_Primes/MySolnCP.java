package Count_Primes;

public class MySolnCP {

    //Given an integer n, return the number of prime numbers that are strictly 
    // less than n.
    public static void main(String[] args) {
        
    }

    // two ways;
    /*
     * brute force:
     * count backwards and count prime numbers from n
     * 
     * Sieve of Eratosthenes , O(n) memory ,runtime O(n log (log n))
     * 
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
           isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
           if (!isPrime[i]) continue;
           for (int j = i * i; j < n; j += i) {
              isPrime[j] = false;
           }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
           if (isPrime[i]) count++;
        }
        return count;
     }
}
