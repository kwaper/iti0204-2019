package ee.ttu.algoritmid.fibonacci;
import java.math.BigDecimal;

public class AL01A {

    /**
     * Compute the Fibonacci sequence number.
     * @param n The number of the sequence to compute.
     * @return The n-th number in Fibonacci series.
     */
    public String iterativeF(int n) {
        // TODO
        BigDecimal first = BigDecimal.ONE;
        BigDecimal second = BigDecimal.ONE;
        BigDecimal result = BigDecimal.ZERO;
        if (n == 0){
            return "0";
        }
        if (n == 1 || n == 2){
            return "1";
        } else if (n > 2){
            for (int i = 3; i <= n ; i++){
                result = BigDecimal.ZERO;
                result = result.add(first);
                result = result.add(second);
                first = second;
                second = result;
            } return String.valueOf(result);
        }
        return "1";
    }


    public static void main(String[] args) {
        System.out.println("HI");
    }
}
