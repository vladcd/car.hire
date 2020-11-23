package ro.agilehub.javacourse.car.hire.fleet.enums;

public enum CarClassEnum {
    COUPE("Coupe"),
    HATCHBACK("Hatchback"),
    LIMOUSINE("Limousine"),
    SEDAN("Sedan"),
    MINIVAN("Minivan"),
    SUV("SUV");

    private final String value;

    CarClassEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
