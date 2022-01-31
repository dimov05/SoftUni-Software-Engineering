package aquarium;

public class Fish {
    public String name;
    public String color;
    public int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    @Override
    public String toString() {
        return String.format("Fish: %s%n" +
                        "Color: %s%n" +
                        "Number of fins: %d%n",
                this.name, this.color, this.fins);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }
}
