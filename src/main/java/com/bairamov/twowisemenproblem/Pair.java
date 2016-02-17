package com.bairamov.twowisemenproblem;

public class Pair {
    int x;
    int y;

    public Pair(int right, int left) {
        this.x = right;
        this.y = left;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSum() {
        return x + y;
    }

    public int getProduct() {
        return x * y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (x != pair.x) return false;
        return y == pair.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                ", sum=" + getSum() +
                ", prod=" + getProduct() +
                '}';
    }
}
