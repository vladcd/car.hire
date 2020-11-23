package ro.agilehub.javacourse.car.hire.fleet.enums;

public enum CarStatusEnum {
    ACTIVE("Active"),
    DELETED("Deleted");

    private final String value;

    CarStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
