package math;

public class CalculatorSecure implements Calculator{

    private final Calculator calculator;

    public CalculatorSecure(final Calculator calculator) {
        this.calculator = calculator;
    }

    public double add(final double a, final double b) {
        System.out.println("Du kommst hier rein");
        return calculator.add(a, b);
    }

    public double sub(final double a, final double b) {
        return calculator.sub(a, b);
    }
}
