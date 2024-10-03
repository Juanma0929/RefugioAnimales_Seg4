package model;

public class Animal {
    private String animalName;
    private String animalID;
    private String animalSpecie;
    private boolean vaccinationStatus;
    private boolean neutered;

    public Animal(String animalName, String animalID, String animalSpecie, boolean vaccinationStatus, boolean neutered) {
        this.animalName = animalName;
        this.animalID = animalID;
        this.animalSpecie = animalSpecie;
        this.vaccinationStatus = vaccinationStatus;
        this.neutered = neutered;
    }

    // Getters y Setters
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalID() {
        return animalID;
    }

    public void setAnimalID(String animalID) {
        this.animalID = animalID;
    }

    public String getAnimalSpecie() {
        return animalSpecie;
    }

    public void setAnimalSpecie(String animalSpecie) {
        this.animalSpecie = animalSpecie;
    }

    public boolean isVaccinationStatus() {
        return vaccinationStatus;
    }

    public void setVaccinationStatus(boolean vaccinationStatus) {
        this.vaccinationStatus = vaccinationStatus;
    }

    public boolean isNeutered() {
        return neutered;
    }

    public void setNeutered(boolean neutered) {
        this.neutered = neutered;
    }
}
