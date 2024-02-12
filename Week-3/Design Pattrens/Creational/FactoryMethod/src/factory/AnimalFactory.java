package factory;

import family.Animal;

public interface AnimalFactory {
    Animal createAnimal(int type);
}
