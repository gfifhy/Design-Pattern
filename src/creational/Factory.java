package creational;


//Product Interface
interface Animal {
    public void talk();
}

//Concrete Products
class Cat implements Animal {
    @Override
    public void talk() {
        System.out.println("I am cat");
    }
}

class Dog implements Animal {
    @Override
    public void talk() {
        System.out.println("I am dog");
    }
}



//Creator Interface (Factory Interface)
/*interface AnimalFactory {
    public Animal createAnimal();
}*/

//or

abstract class AnimalFactory {
    public abstract Animal createAnimal();

    protected void logCreation(String animalType) {
        System.out.println("Creating animal: " + animalType);
    }
}


// Simple Factory
/*
class AnimalCreator {
    public Animal createAnimal(String animalType) {
        if("cat".equalsIgnoreCase(animalType)) {
            return new Cat();
        }
        else if("dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        }
        return null;
    }
}
*/
//Concrete Creators
class DogFactory extends AnimalFactory {

    @Override
    public Animal createAnimal() {
        logCreation("Dog");
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {

    @Override
    public Animal createAnimal() {
        logCreation("Cat");
        return new Cat();
    }
}

public class Factory {
    public static void main(String[] args) {
        //creating dogs
        AnimalFactory animalFactory = new DogFactory();

        //creating dogs using creators
        Animal dog1 = animalFactory.createAnimal();
        Animal dog2 = animalFactory.createAnimal();
        Animal dog3 = animalFactory.createAnimal();

        dog1.talk();
        dog2.talk();
        dog3.talk();

        AnimalFactory catFactory = new CatFactory();
        Animal cat1 = catFactory.createAnimal();
        Animal cat2 = catFactory.createAnimal();
        Animal cat3 = catFactory.createAnimal();

        cat1.talk();
        cat2.talk();
        cat3.talk();

    }
}
