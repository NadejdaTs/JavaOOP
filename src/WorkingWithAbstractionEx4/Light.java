package WorkingWithAbstractionEx4;

public class Light {
    private Color color;

    public Light (Color color){
        this.color = color;
    }
    public void changeColor(){

        if(color.toString().equals("GREEN")){
            this.color = Color.YELLOW;
        } else if(color.toString().equals("RED")){
            this.color = Color.GREEN;
        } else if(color.toString().equals("YELLOW")){
            this.color = Color.RED;
        }
    }

    public Color getColor(){
        return color;
    }
}
