package entity;

public enum TransportName {
    BUS(1.2),
    TRAIN(1.0),
    PLAIN(2.5),
    SHIP(3.0);

    public double coefficient;

    TransportName(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
