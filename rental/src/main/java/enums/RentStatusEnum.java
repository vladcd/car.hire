package enums;

public enum RentStatusEnum {
    ACTIVE("Active"),
    CANCELED("Canceled");

    private String value;

    RentStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
