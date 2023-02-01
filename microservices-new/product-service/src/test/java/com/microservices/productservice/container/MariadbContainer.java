package com.microservices.productservice.container;

import com.microservices.productservice.EnvironmentVariable;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.utility.DockerImageName;

@Transactional
@ActiveProfiles("test")
@ExtendWith({SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class MariadbContainer {

    private static final String IMAGE_VERSION = "mariadb:10.2";
    static final MariaDBContainer<?> mysqlContainer;

    static {
        mysqlContainer =
                new MariaDBContainer<>(DockerImageName.parse(IMAGE_VERSION))
                        .withUsername(EnvironmentVariable.MARIADB_USER)
                        .withPassword("")
                        .withDatabaseName(EnvironmentVariable.MARIADB_DB)
                        .withInitScript("db/dump_start_container.sql")
                        .withReuse(true);

        mysqlContainer.addExposedPort(EnvironmentVariable.MARIADB_PORT_TEST);
        mysqlContainer.start();
    }

    @DynamicPropertySource
    static void datasourceConfig(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
        registry.add("spring.datasource.password", mysqlContainer::getPassword);
        registry.add("spring.datasource.username", mysqlContainer::getUsername);
    }

}
