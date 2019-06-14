package ml2293.math;

import java.math.BigInteger;

public class MersenneNumber {

    public static boolean isPrime(int p) {
        if (p == 2) {
            return true;
        } else if (p <= 1 || p % 2 == 0) {
            return false;
        } else {
            int to = (int) Math.sqrt(p);
            for (int i = 3; i <= to; i += 2) {
                if (p % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isMersennePrime(int p) {
        if (p == 2) {
            return true;
        } else {
            BigInteger m_p = BigInteger.ONE.shiftLeft(p).subtract(BigInteger.ONE);
            BigInteger s = BigInteger.valueOf(4);
            for (int i = 3; i <= p; i++) {
                s = s.multiply(s).subtract(BigInteger.valueOf(2)).mod(m_p);
            }
            return s.equals(BigInteger.ZERO);
        }
    }

    public static void main(String[] args) {       
        if (args.length > 0) {
            int p = Integer.parseInt(args[0]);
            if (isPrime(p) && isMersennePrime(p)) {
                System.out.print(" M" + p + " is prime!");
            } else {
                System.out.print(" 2^" + p + "-1 is composite.");
            }
        } else {
            int upb = 5000;
            System.out.print(" M[2.." + upb + "] 中找到的梅森质数有:\nM2 ");
            for (int p = 3; p <= upb; p += 2) {
                if (isPrime(p) && isMersennePrime(p)) {
                    System.out.print(" M" + p);
                }
            }
        }
    }
}
