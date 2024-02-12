package family;

public class Tiger implements Animal{
    public Tiger(){
        System.out.println("Tiger Object Created");
    }
    @Override
    public void getAnimalData() {
        System.out.println("Retrieving Tiger Data.....");
    }
}
