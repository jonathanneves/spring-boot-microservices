package com.microservices.productservice;

public class EnvironmentVariable {

    /* DB */
    public static final String MARIADB_DB = System.getenv("MARIADB_DB");
    public static final String MARIADB_USER = System.getenv("MARIADB_USER");
    public static final String MARIADB_PASSW = System.getenv("MARIADB_PASS");
    public static final String MARIADB_PORT = System.getenv("MARIADB_PORT");
    public static final Integer MARIADB_PORT_TEST = Integer.valueOf(System.getenv("MARIADB_PORT_TEST"));
}
