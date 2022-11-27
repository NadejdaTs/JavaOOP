package InterfacesAndAbstractionEx4;

public class Robot implements Person, Identifiable{
    private String id;
    private String model;

    public Robot(String id, String model){
        this.id = id;
        this.model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String getName() {
        return this.getName();
    }

    @Override
    public int getAge() {
        return this.getAge();
    }
}

