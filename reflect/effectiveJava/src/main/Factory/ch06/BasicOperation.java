package main.Factory.ch06;

/**
 * Created by yangshenneng on 15/2/23.
 */
public enum BasicOperation {
    PLUS("+") {
        double apply(double x, double y) {return x + y;}
    },
    MINUS("-") {
        double apply(double x, double y) {return x - y;}
    },
    TIMES("*") {
        double apply(double x, double y) {return x * y;}
    },
    DIVIDE("/") {
        double apply(double x, double y) {return x / y;}
    };
    private final String symbol;
    BasicOperation(String symbol) {
        this.symbol = symbol;
    }
    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);
}
