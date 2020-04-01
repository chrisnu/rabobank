package com.rabobank.chris.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class PowerOfAttorneysControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PowerOfAttorneysController powerOfAttorneysController;

    @Test
    public void testContextPowerOfAttorney() {
        Assertions.assertNotNull(powerOfAttorneysController);
    }

    @Test
    public void testResponse() {
        Assertions.assertTrue(restTemplate.getForObject(
                String.format("http://localhost:%s/power-of-attorneys", port), String.class)
                .contains("\"id\":"));

    }

}
