package ui;

import java.util.Scanner;
import model.Controller;

public class ShelterSystem {
    public Scanner sc = new Scanner(System.in);
    private Controller controller = new Controller();

    public static void main(String[] args) {
        ShelterSystem m = new ShelterSystem();
        m.createShelter();
        m.menu();
    }
    
    /**
     * Le pregunta al usuario la información del refugio que quiere agregar
     */
    public void createShelter() {
        System.out.println("--Bienvenido a la aplicación de la administración del refugio--");

        System.out.print("¿Cómo se llama el refugio? ");
        String shelterName = sc.nextLine();

        System.out.print("¿Cuál es la dirección del refugio? ");
        String shelterAddress = sc.nextLine();

        System.out.print("Ingrese el presupuesto del refugio: ");
        double shelterBudget = sc.nextDouble();
        sc.nextLine(); 
        System.out.print("¿Cuántos animales acoge el refugio? ");
        int shelterCapacity = sc.nextInt();
        sc.nextLine(); 

        controller.createShelter(shelterName, shelterAddress, shelterBudget, shelterCapacity);
    }

    /**
     * Menú que, después de registrar el refugio, le pregunta al usuario la opción que quiere. Entre registrar un animal, consultar
     * la información de un animal por ID o nombre, obtener el número de animales por specie o salir del menú
     */
    public void menu() {
        int option = 0;

        while (option != 4) {
            System.out.println("--Menú del programa organizador del refugio--");
            System.out.println("1. Registrar un animal");
            System.out.println("2. Consultar la información de un animal por ID o nombre");
            System.out.println("3. Obtener el número de animales por especie");
            System.out.println("4. Salir");

            option = sc.nextInt();
            sc.nextLine(); 
            switch (option) {
                case 1:
                    registerAnimal();
                    break;
                case 2:
                    getAnimalByAttribute();
                    break;
                case 3:
                    speciesQuantity();
                    break;
                case 4:
                    System.out.println("Has salido del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

    /**
     * Método que le pregunta la información del animal a registrar, después de que el usuario haya puesto la opción de 
     * registrar animal
     */
    public void registerAnimal() {
        System.out.print("Ingrese el nombre del animal: ");
        String animalName = sc.nextLine();

        System.out.print("Ingrese el ID del animal: ");
        String animalID = sc.nextLine();

        System.out.print("¿Cuál es la especie del animal? ");
        String animalSpecie = sc.nextLine().toLowerCase();

        System.out.print("¿El animal está vacunado? (si/no): ");
        boolean vaccinationStatus = sc.nextLine().equalsIgnoreCase("si");

        System.out.print("¿El animal está esterilizado? (si/no): ");
        boolean neutered = sc.nextLine().equalsIgnoreCase("si");

        String msg = controller.addAnimal(animalName, animalID, animalSpecie, vaccinationStatus, neutered);
        System.out.println(msg);
    }

    /**
     *  Método que, después de que el usuario haya elegido la opción de buscar un animal por ID o nombre, le devuelve al
     * usuario la información del animal que buscó por nombre o identificación
     * 
     */
    public void getAnimalByAttribute() {
        System.out.println("1. Para consultar animal por nombre");
        System.out.println("2. Para consultar animal por ID");

        int option = sc.nextInt();
        sc.nextLine();

        String attribute = "";

        if (option == 1) {
            System.out.print("Ingrese el nombre del animal: ");
            attribute = sc.nextLine();
        } else if (option == 2) {
            System.out.print("Ingrese el ID del animal: ");
            attribute = sc.nextLine();
        } else {
            System.out.println("No es una opción válida");
            return;
        }

        String msg = controller.getAnimalByAttribute(option, attribute);
        System.out.println(msg);
    }

    /**
     * Método que devuelve la cantidad de ejemplares de la especie elegida por el usuario
     */
    public void speciesQuantity() {
        System.out.print("Ingrese el nombre de la especie: ");
        String specie = sc.nextLine().toLowerCase();

        int quantity = controller.getAnimalsBySpecie(specie);
        System.out.println("La especie " + specie + " tiene " + quantity + " ejemplares.");
    }
}
