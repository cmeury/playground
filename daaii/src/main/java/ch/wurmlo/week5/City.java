package ch.wurmlo.week5;

public class City {

    double x, y;

    public City(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(City otherCity) {
        double z = otherCity.getX();
        double w = otherCity.getY();
        return Math.sqrt(Math.pow(x - z, 2) + Math.pow(y - w, 2));
    }

    @Override
    public String toString() {
        return "City[x=" + this.x + ",y=" + this.y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (Double.compare(city.x, x) != 0) return false;
        if (Double.compare(city.y, y) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = x != +0.0d ? Double.doubleToLongBits(x) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
