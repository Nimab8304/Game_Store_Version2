package ir.ac.kntu;

public class Controller extends HardWare{

    private String system;

    private String type;

    public Controller(String name, String description, double price, int count, String system, String type) {
        super(name, description, price, count);
        this.system = system;
        this.type = type;
    }

    public Controller() {

    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
