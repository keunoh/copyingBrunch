package com.brunch.kaltz.junittest;

public class Calculate {
    private CalculateType calculateType;
    private int num1;
    private int num2;

    public Calculate(CalculateType calculateType, int num1, int num2) {
        this.calculateType = calculateType;
        this.num1 = num1;
        this.num2 = num2;
    }

    public CalculateType getCalculateType() {
        return calculateType;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int calculate() {
        int result = 0;
        if (calculateType == CalculateType.ADD) {
            result = num1 + num2;
        }
        else if (calculateType == CalculateType.MINUS) {
            result = num1 - num2;
        }
        else if (calculateType == CalculateType.MULTIPLY) {
            result = num1 * num2;
        }
        else if (calculateType == CalculateType.DIVIDE) {
            result = num1 / num2;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Calculate{" +
                "calculateType=" + calculateType +
                ", num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}
