package family;

public class Lion implements Animal{
    public Lion(){
        System.out.println("Lion Object Created");
    }
    @Override
    public void getAnimalData() {
        System.out.println("Retriving Loin Data ....");
    }
}
