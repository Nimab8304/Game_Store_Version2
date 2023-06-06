package ir.ac.kntu;

public class Monitor extends HardWare{

    private double size;

    private int refreshRate;

    private int time;

    public Monitor(String name, String description, double price, int count, double size, int refreshRate, int time) {
        super(name, description, price, count);
        this.size = size;
        this.refreshRate = refreshRate;
        this.time = time;
    }

    public Monitor() {
        super();
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
