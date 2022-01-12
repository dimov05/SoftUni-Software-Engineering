package ExerciseDefiningClasses.RawData;

public class Tyres {
    double tire1Pressure;
    int tire1Age;
    double tire2Pressure;
    int tire2Age;
    double tire3Pressure;
    int tire3Age;
    double tire4Pressure;
    int tire4Age;

    public Tyres(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tire1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tire2Age;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tire3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tire4Age;
    }
    public boolean ifLower(){
        return tire1Pressure<1 || tire2Pressure<1
                ||tire3Pressure<1 ||tire4Pressure<1;
    }

}
