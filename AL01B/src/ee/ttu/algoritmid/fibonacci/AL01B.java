package ee.ttu.algoritmid.fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class AL01B {

    private BigDecimal total = BigDecimal.ZERO;


    /**
     * Estimate or find the exact time required to compute the n-th Fibonacci number.
     *
     * @param n The n-th number to compute.
     * @return The time estimate or exact time in YEARS.
     */
    public static String timeToComputeRecursiveFibonacci(int n) {
        if (n <= 40) {
            long startTime = System.currentTimeMillis();
            recursiveF(n);
//            computeLines(n);
            long finalTime = System.currentTimeMillis();
            return String.valueOf((finalTime - startTime) * 3.17098E-11);
        } else {
//        recursiveF(n);
            computeLines(n);
            return String.valueOf((computeLines(n).multiply(new BigDecimal(3.92884422E-8))).divide(new BigDecimal(496740421), 10, RoundingMode.CEILING));
        }
    }

    public static BigDecimal computeLines(int n) {
        Map<Integer, BigDecimal> indexLines = new HashMap<>();
        indexLines.put(0, BigDecimal.valueOf(1));
        indexLines.put(1, BigDecimal.valueOf(1));
        indexLines.put(2, BigDecimal.valueOf(4));
        if (n <= 2) {
            return BigDecimal.ONE;
        } else {
            for (int i = 3; i <= n; i++) {
                indexLines.put(i, BigDecimal.valueOf(2).add(indexLines.get(i - 1).add(indexLines.get(i - 2))));
            }
//            System.out.println(indexLines);
            return indexLines.get(n);
        }

    }

    /**
     * Compute the Fibonacci sequence number recursively.
     * (You need this in the timeToComputeRecursiveFibonacci(int n) function!)
     *
     * @param n The n-th number to compute.
     * @return The n-th Fibonacci number as a string.
     */
    public static BigInteger recursiveF(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        return recursiveF(n - 1).add(recursiveF(n - 2));
    }

    public static void main(String[] args) {
        System.out.println(timeToComputeRecursiveFibonacci(50));
//        System.out.println(computeLines(400));
    }
}
