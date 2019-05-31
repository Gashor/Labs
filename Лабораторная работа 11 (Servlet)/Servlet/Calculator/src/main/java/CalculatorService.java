import java.math.BigDecimal;

public class CalculatorService {
    public String calculate (String x, String y, String operation) {
        BigDecimal xValue = new BigDecimal(x);
        BigDecimal yValue = new BigDecimal(y);

        switch (operation) {
            case "+":
                return xValue.add(yValue).toString();
            case "-":
                return xValue.subtract(yValue).toString();
            case "*":
                return xValue.multiply(yValue).toString();
            case "/":
                return xValue.divide(yValue).toString();
        }

        return "Error";
    }
}
