package model;

public class Shelter {
    private String shelterAddress;
    private String shelterName;
    private double shelterBudget;
    private int animalCapacity;
    private Animal[] animals;

    public Shelter(String shelterAddress, String shelterName, double shelterBudget, int animalCapacity) {
        this.shelterAddress = shelterAddress;
        this.shelterName = shelterName;
        this.shelterBudget = shelterBudget;
        this.animalCapacity = animalCapacity;
        this.animals = new Animal[animalCapacity];
    }

    public boolean checkSpace() {
        for (Animal animal : animals) {
            if (animal == null) {
                return true; 
            }
        }
        return false; 
    }

    public void addAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal; 
                return; 
            }
        }
    }

    public Animal getAnimalByName(String animalName) {
        for (Animal animal : animals) {
            if (animal != null && animal.getAnimalName().equals(animalName)) {
                return animal;
            }
        }
        return null; 
    }

    public Animal getAnimalByID(String animalID) {
        for (Animal animal : animals) {
            if (animal != null && animal.getAnimalID().equals(animalID)) {
                return animal;
            }
        }
        return null; 
    }


    public Animal[] getAnimals() {
        return animals;
    }
}
