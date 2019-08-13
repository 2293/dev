
import java.math.BigInteger;
import java.util.Random;

public class FactorLab {

//    public static BigInteger factor(BigInteger n) {
//        //n=p*q+r
//        BigInteger p,q,r;
//        do {
//            q=f(q,r);
//            ...
//            p=g(p,r);
//        } while (r != 0);
//    }
    public static BigInteger factor5(BigInteger n) {
        BigInteger x, delta, g = BigInteger.ONE;
        for (int i = 60; i < 200; i++) {
            System.out.println(i);
            x = n.sqrt();
            delta = n.subtract(x).divide(BigInteger.valueOf(i));
            for (int j = i - 1; j > 0; j--) {
                x = x.add(delta);

                for (int k = 0; k < 2293; k++) {
                    g = n.gcd(x);
                    if (!g.equals(BigInteger.ONE)) {
                        System.out.println(g + ";" + i + ";" + j + ";" + k);
                        return g;
                    }
                    x = x.add(BigInteger.ONE);
                }

            }
        }
        return BigInteger.ONE;
    }

    public static BigInteger form235(BigInteger n) {
        //BigInteger n = m.add(BigInteger.ZERO);
        //BigInteger is immutable, just like String, Integer, so don't need to copy. 
        int di = 0, ei = 0, gi = 0;
        while (n.mod(BigInteger.TWO) == BigInteger.ZERO) {
            di++;
            n = n.divide(BigInteger.TWO);
        }
        while (n.mod(BigInteger.valueOf(3)) == BigInteger.ZERO) {
            ei++;
            n = n.divide(BigInteger.valueOf(3));
        }
        while (n.mod(BigInteger.valueOf(5)) == BigInteger.ZERO) {
            gi++;
            n = n.divide(BigInteger.valueOf(5));
        }
        BigInteger[] sr = n.sqrtAndRemainder();
        System.out.format("[%d,%d,%d];  \n", di, ei, gi);
        // System.out.format("[%d,%d,%d];    %s, %s\n", di, ei, gi, sr[0], sr[1]);
        return sr[1];
    }

    public static BigInteger factor235(BigInteger n) {
        Random rnd = new Random();
        int numBits = n.bitLength() - 1;
        BigInteger x, y;
        do {

            x = new BigInteger(numBits, rnd);
            BigInteger[] sr = {BigInteger.ONE, BigInteger.ONE};
            y = x.multiply(x).mod(n);
        } while (!form235(y).equals(BigInteger.ZERO));
        return BigInteger.ONE;
    }

    public static BigInteger factorWithFibonacciNumbers(BigInteger n) {
        BigInteger g = BigInteger.ONE;
        BigInteger a = BigInteger.valueOf(5L), b = BigInteger.valueOf(8L), c = BigInteger.valueOf(13L);
        while (true) {
            a = b.add(c).mod(n);
            g = n.gcd(a);
            if (!g.equals(BigInteger.ONE)) {
                break;
            }
            g = n.gcd(a.add(BigInteger.ONE));
            if (!g.equals(BigInteger.ONE)) {
                break;
            }

            b = c.add(a).mod(n);
            g = n.gcd(b);
            if (!g.equals(BigInteger.ONE)) {
                break;
            }
            g = n.gcd(b.add(BigInteger.ONE));
            if (!g.equals(BigInteger.ONE)) {
                break;
            }

            c = a.add(b).mod(n);
            g = n.gcd(c);
            if (!g.equals(BigInteger.ONE)) {
                break;
            }
            g = n.gcd(c.add(BigInteger.ONE));
            if (!g.equals(BigInteger.ONE)) {
                break;
            }
        }
        return g;
    }

//    public static BigInteger factorWithPrimesSharp(BigInteger n) {
//        BigInteger od = BigInteger.valueOf(3*5);
//        
//        BigInteger g = n.gcd(od.subtract(BigInteger.two));
//    BigInteger g = n.gcd(od.add(BigInteger.two));
//        
//        return g;
//    }
    public static void test5() {
        int p = 1277;
        BigInteger n = BigInteger.TWO.pow(p).subtract(BigInteger.ONE);
        System.out.println(factor5(n));
    }

    public static void main(String[] args) {
//        int p = 1277;
//        BigInteger n = BigInteger.TWO.pow(p).subtract(BigInteger.ONE);
////        BigInteger q = factorWithFibonacciNumbers(n);
//        factor235(n);
//        // System.out.println("q=" + q);
        test5();
    }

}
