package model;

public class SpeciesController {

    private Species[] species;

    public SpeciesController() {
        this.species = new Species[80];
    }

    public boolean registrarEspecie(String nombre, String nombreCientifico, SpeciesType tipoEspecie, 
                                    Boolean tieneFlores, Boolean tieneFrutas, Double alturaMaxima, 
                                    Boolean esMigratoria, Double pesoMaximo) {
        for (int i = 0; i < species.length; i++) {
            if (species[i] == null) {
                species[i] = new Species(nombre, nombreCientifico, tipoEspecie, tieneFlores, 
                                         tieneFrutas, alturaMaxima, esMigratoria, pesoMaximo);
                return true;
            }
        }
        return false;
    }

    public String mostrarListaEspecies() {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < species.length; i++) {
            if (species[i] != null) {
                msg.append("\n").append(i + 1).append(". ").append(species[i].getNombre());
            }
        }
        return msg.toString();
    }

    public Species obtenerEspecie(int indice) {
        return species[indice];
    }

    public boolean eliminarEspecie(int indice) {
        if (indice >= 0 && indice < species.length && species[indice] != null) {
            species[indice] = null;
            return true;
        }
        return false;
    }
}
