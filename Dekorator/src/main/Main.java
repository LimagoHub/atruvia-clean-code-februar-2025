package main;

import client.CalcClient;
import math.*;

public class Main {
    public static void main(String[] args) {

        CalculatorFactory.setLogger(true);
        Calculator calculator = CalculatorFactory.createCalculator();

        CalcClient client = new CalcClient(calculator);
        client.go();
    }
}