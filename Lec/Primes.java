public class Primes {
    public static void main(String[] args) {
        /**
         * A prime number is an integer greater than 1 that has no divisors smaller
         * thatn itself other than 1.
         * 
         * k <= sqrt(N) if N/k >= sqrt(N) if k divides N then N/k divides N
         * 
         * try all potential divisors up to and including the square root
         */
        printPrimes(16);
    }

    private static void printPrimes(int limit) {
        /**
         * { For every integer, x, between 2 and LIMIT, print it if isPrime(x), 10 to a
         * line.}
        */
        for (int x=2; x<=limit; x++){
            if (isPrime(x)) System.out.println(x);
        }
    }

    /** True if X is prime */
    private static boolean isPrime(int x) {
        if (x<=1)
            return false;
        else
            return !isDivisible(x, 2);
    }

    private static boolean isDivisible(int x, int k){
        if (k >= x)
            return false;
        else if (x % k == 0)
            return true;
        else // if (k < x && x % k != 0)
            return isDivisible(x, k+1);
    }



}