package InterfacesAndAbstractionLab3;

public class Chinese implements Person {
    private String name;

    public Chinese(String name){
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
