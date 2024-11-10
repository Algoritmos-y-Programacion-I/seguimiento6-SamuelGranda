package model;

public class Species {
    private String nombre;
    private String nombreCientifico;
    private SpeciesType tipoEspecie;
    private Boolean tieneFlores;
    private Boolean tieneFrutas;
    private Double alturaMaxima;
    private Boolean esMigratoria;
    private Double pesoMaximo;

    public Species(String nombre, String nombreCientifico, SpeciesType tipoEspecie, Boolean tieneFlores, 
                   Boolean tieneFrutas, Double alturaMaxima, Boolean esMigratoria, Double pesoMaximo) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.tipoEspecie = tipoEspecie;
        this.tieneFlores = tieneFlores;
        this.tieneFrutas = tieneFrutas;
        this.alturaMaxima = alturaMaxima;
        this.esMigratoria = esMigratoria;
        this.pesoMaximo = pesoMaximo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SpeciesType getTipoEspecie() {
        return tipoEspecie;
    }

    public void actualizar(String nombre, SpeciesType tipoEspecie, Boolean tieneFlores, Boolean tieneFrutas, 
                           Double alturaMaxima, Boolean esMigratoria, Double pesoMaximo) {
        this.nombre = nombre;
        this.tipoEspecie = tipoEspecie;
        this.tieneFlores = tieneFlores;
        this.tieneFrutas = tieneFrutas;
        this.alturaMaxima = alturaMaxima;
        this.esMigratoria = esMigratoria;
        this.pesoMaximo = pesoMaximo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Nombre Científico: " + nombreCientifico + 
               ", Tipo: " + tipoEspecie + 
               ((tieneFlores != null) ? ", Tiene Flores: " + tieneFlores : "") + 
               ((tieneFrutas != null) ? ", Tiene Frutas: " + tieneFrutas : "") + 
               ((alturaMaxima != null) ? ", Altura Máxima: " + alturaMaxima + " metros" : "") + 
               ((esMigratoria != null) ? ", Es Migratoria: " + esMigratoria : "") + 
               ((pesoMaximo != null) ? ", Peso Máximo: " + pesoMaximo + " kg" : "");
    }
}
