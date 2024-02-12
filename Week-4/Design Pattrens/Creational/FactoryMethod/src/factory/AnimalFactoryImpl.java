package factory;

import family.Animal;
import family.Lion;
import family.Tiger;
import family.Wolf;

public class AnimalFactoryImpl implements AnimalFactory{
    @Override
    public Animal createAnimal(int type) {
        switch (type){
            case 1: return new Lion();
            case 2: return new Tiger();
            case 3: return new Wolf();
            default: return null;
        }
    }
}
