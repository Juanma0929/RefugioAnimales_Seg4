package model;

public class Controller {
    private Shelter shelter;

    public Controller() {
    }

    public void createShelter(String shelterName, String shelterAddress, double shelterBudget, int animalCapacity) {
        shelter = new Shelter(shelterAddress, shelterName, shelterBudget, animalCapacity);
    }

    public String addAnimal(String animalName, String animalID, String animalSpecie, boolean vaccinationStatus, boolean neutered) {
        String msg = "Se agregó el animal correctamente.";
        Animal animal = new Animal(animalName, animalID, animalSpecie, vaccinationStatus, neutered);

        if (shelter != null && shelter.checkSpace()) {
            shelter.addAnimal(animal);
        } else {
            msg = "No se puede agregar un animal porque se alcanzó el límite de espacio";
        }

        return msg;
    }

    public String getAnimalByAttribute(int option, String attribute) {
        Animal animal = null;

        if (option == 1) {
            animal = shelter.getAnimalByName(attribute);
        } else if (option == 2) {
            animal = shelter.getAnimalByID(attribute);
        }

        if (animal == null) {
            return "No se encontró ningún animal con el ID o nombre especificado.";
        }

        String vac = animal.isVaccinationStatus() ? "Si" : "No";
        String neut = animal.isNeutered() ? "Si" : "No";

        return String.format("Nombre animal: %s\nID animal: %s\nSpecie: %s\nVacunado? %s\nEsterilizado? %s", 
                             animal.getAnimalName(), animal.getAnimalID(),animal.getAnimalSpecie(), vac, neut);
    }

    public int getAnimalsBySpecie(String animalSpecie) {
        Animal[] allAnimals = shelter.getAnimals();
        int counter = 0;

        for (Animal animal : allAnimals) {
            if (animal != null && animal.getAnimalSpecie().equals(animalSpecie)) {
                counter++;
            }
        }

        return counter;
    }
}
