public class Primes2 {
    public static void main(String[] args) {
        /**
         * A prime number is an integer greater than 1 that has no divisors smaller
         * thatn itself other than 1.
         * 
         * k <= sqrt(N) if N/k >= sqrt(N) if k divides N then N/k divides N
         * 
         * try all potential divisors up to and including the square root
         */
        printPrimes(35);
    }

    private static void printPrimes(int limit) {
        /**
         * { For every integer, x, between 2 and LIMIT, print it if isPrime(x), 10 to a
         * line.}
        */
        int np;
        np = 0;

        for (int p=2; p<=limit; p+=1){
            if (isPrime(p)) {
                System.out.print(p + " ");
                np +=1;
                if (np%10==0)
                    System.out.println();
            }
        }
        if (np%10!=0)
            System.out.println();
    }

    /** True if X is prime */
    private static boolean isPrime(int x) {
        if (x<=1)
            return false;
        else
            return !isDivisible(x, 2);
    }

    private static boolean isDivisible(int x, int k){
        int k1 = k;
        int limit = (int) Math.sqrt(x);
        while (k1 <= limit){
            if (x % k1 ==0)
                return true;
            k1 ++;
        }
        return false;
    }



}