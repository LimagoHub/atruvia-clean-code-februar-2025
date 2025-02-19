package math;

public class CalculatorLogger implements Calculator{

    private final Calculator calculator;

    public CalculatorLogger(final Calculator calculator) {
        this.calculator = calculator;
    }

    public double add(final double a, final double b) {
        System.out.println("Add wurde gerufen");
        return calculator.add(a, b);
    }

    public double sub(final double a, final double b) {
        return calculator.sub(a, b);
    }
}
