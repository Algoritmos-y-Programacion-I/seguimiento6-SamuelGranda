package ui;

import java.util.Scanner;
import model.SpeciesController;
import model.SpeciesType;

public class SpeciesExecutable {

    private Scanner lector;
    private SpeciesController speciesController;

    public static void main(String[] args) {
        SpeciesExecutable exe = new SpeciesExecutable();
        exe.mostrarMenuPrincipal();
    }

    public SpeciesExecutable() {
        lector = new Scanner(System.in);
        speciesController = new SpeciesController();
    }

    public void mostrarMenuPrincipal() {
        System.out.println("Bienvenido al sistema de Especies de Icesi");

        boolean salir = false;

        while (!salir) {
            System.out.println("\nSeleccione una opción");
            System.out.println("1. Registrar una Especie");
            System.out.println("2. Editar una Especie");
            System.out.println("3. Eliminar una Especie");
            System.out.println("0. Salir");

            int opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    registrarEspecie();
                    break;
                case 2:
                    editarEspecie();
                    break;
                case 3:
                    eliminarEspecie();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema");
                    salir = true;
                    break;
                default:
                    System.out.println("Debe seleccionar una opción válida");
                    break;
            }
        }
    }

    public void registrarEspecie() {
        System.out.print("Nombre de la especie: ");
        String nombre = lector.next();

        System.out.print("Nombre científico: ");
        String nombreCientifico = lector.next();

        System.out.println("Tipo de especie: 1. Flora Terrestre, 2. Flora Acuática, 3. Ave, 4. Mamífero, 5. Fauna Acuática");
        int tipo = lector.nextInt();
        SpeciesType tipoEspecie = SpeciesType.values()[tipo - 1];

        Boolean tieneFlores = null, tieneFrutas = null, esMigratoria = null;
        Double alturaMaxima = null, pesoMaximo = null;

        if (tipoEspecie == SpeciesType.FLORA_TERRESTRE || tipoEspecie == SpeciesType.FLORA_ACUATICA) {
            System.out.print("¿Tiene flores? (true/false): ");
            tieneFlores = lector.nextBoolean();
            System.out.print("¿Tiene frutas? (true/false): ");
            tieneFrutas = lector.nextBoolean();
            System.out.print("Altura máxima (en metros): ");
            alturaMaxima = lector.nextDouble();
        } else {
            System.out.print("¿Es migratoria? (true/false): ");
            esMigratoria = lector.nextBoolean();
            System.out.print("Peso máximo (en kg): ");
            pesoMaximo = lector.nextDouble();
        }

        if (speciesController.registrarEspecie(nombre, nombreCientifico, tipoEspecie, tieneFlores, tieneFrutas, alturaMaxima, esMigratoria, pesoMaximo)) {
            System.out.println("Especie registrada exitosamente");
        } else {
            System.out.println("Error: no se pudo registrar la especie");
        }
    }

    public void editarEspecie() {
        System.out.println("Seleccione la especie que desea editar: ");
        System.out.println(speciesController.mostrarListaEspecies());
        int indice = lector.nextInt() - 1;

        if (speciesController.obtenerEspecie(indice) != null) {
            registrarEspecie();
        } else {
            System.out.println("Especie no encontrada.");
        }
    }

    public void eliminarEspecie() {
        System.out.println("Seleccione la especie que desea eliminar: ");
        System.out.println(speciesController.mostrarListaEspecies());
        int indice = lector.nextInt() - 1;

        if (speciesController.eliminarEspecie(indice)) {
            System.out.println("Especie eliminada exitosamente");
        } else {
            System.out.println("Error al intentar eliminar la especie");
        }
    }
}
