package EncapsulationEx4;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if(!flourType.equals("white") && !flourType.equals("wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!bakingTechnique.equals("crispy") && !bakingTechnique.equals("chewy") && !bakingTechnique.equals("homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        //(2 * weight) * flourType modifier * bakingTechnique modifier
        double flourTypeModifier = getFlourTypeModifier(this.flourType);
        double bakingTechniqueModifier = getBakingTechniqueModifier(this.bakingTechnique);
        return (2 * this.weight) * flourTypeModifier * bakingTechniqueModifier;
    }

    private double getFlourTypeModifier(String flourType) {
        if(flourType.equals("White")) {
            return 1.5;
        }else if(flourType.equals("Wholegrain")){
            return 1;
        }else{
            return 0;
        }
    }

    private double getBakingTechniqueModifier(String bakingTechnique) {
        if(bakingTechnique.equals("Crispy")){
            return 0.9;
        }else if(bakingTechnique.equals("Chewy")){
            return 1.1;
        }else if(bakingTechnique.equals("Homemade")){
            return 1.0;
        }else{
            return 0;
        }
    }

}
