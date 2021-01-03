package ro.agilehub.javacourse.car.hire.boot.security;

import java.util.List;

public class CorsConstants {
    public static final List<String> ALLOWED_ORIGINS = List.of("http://localhost:8090");
    public static final List<String> ALLOWED_METHODS = List.of("*");

    private CorsConstants(){

    }
}
