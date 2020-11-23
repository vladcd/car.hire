package enums;

public enum UserStatusEnum {
    ACTIVE("Active"),
    DELETED("Deleted");

    private final String value;

    UserStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
