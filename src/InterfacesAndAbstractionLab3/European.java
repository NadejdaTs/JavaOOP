package InterfacesAndAbstractionLab3;

public class European implements Person {
    private String name;

    public European(String name){
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
