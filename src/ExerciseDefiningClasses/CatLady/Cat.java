package ExerciseDefiningClasses.CatLady;

public class Cat {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class Siamese extends Cat {
        private final double earsSize;

        public Siamese(String name, double earsSize) {
            super(name);
            this.earsSize = earsSize;
        }

        @Override
        public String toString() {
            return String.format("Siamese %s %.2f", super.getName(), earsSize);
        }
    }

    public static class Cymric extends Cat {
        private final double lengthFur;

        public Cymric(String name, double lengthFur) {
            super(name);
            this.lengthFur = lengthFur;
        }

        @Override
        public String toString() {
            return String.format("Cymric %s %.2f",
                    super.getName(), this.lengthFur);
        }
    }

    public static class StreetExtraordinaire extends Cat {
        private final double decibels;

        public StreetExtraordinaire(String name, double decibels) {
            super(name);
            this.decibels = decibels;
        }

        @Override
        public String toString() {
            return String.format("StreetExtraordinaire %s %.2f",
                    super.getName(), decibels);
        }
    }
}
