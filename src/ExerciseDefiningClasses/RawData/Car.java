package ExerciseDefiningClasses.RawData;

public class Car {
    String model;

    Engine engine;
    Cargo cargo;
    private Tyres tyres;

    public Car(String model, Engine engine, Cargo cargo, Tyres tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.setTyres(tyres);
    }

    public Tyres getTyres() {
        return tyres;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
}
