
import java.math.BigInteger;

public class FactorLab {

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

    public static void main(String[] args) {
        int p = 103;
        BigInteger n = BigInteger.TWO.pow(p).subtract(BigInteger.ONE);
        BigInteger q = factorWithFibonacciNumbers(n);
        System.out.println("q=" + q);
    }

}
