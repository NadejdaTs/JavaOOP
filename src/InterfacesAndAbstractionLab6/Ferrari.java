package InterfacesAndAbstractionLab6;

public class Ferrari implements Car{
    private String driverName;
    private String model;

    public Ferrari(String driverName){
        this.driverName = driverName;
        this.model = "488-Spider";
    }

    @Override
    public String breaks() {
        return "Breaks!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString(){
        return String.format("%s/%s/%s/%s%n", this.getModel(), this.breaks(), this.gas(), this.getDriverName());
    }

    public String getDriverName() {
        return driverName;
    }

    public String getModel() {
        return model;
    }
}
