package family;

public class Wolf implements Animal{
    public Wolf(){
        System.out.println("Wolf Object Created");
    }
    @Override
    public void getAnimalData() {
        System.out.println("Retrieving Wolf Data");
    }
}
