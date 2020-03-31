package com.rabobank.chris.model.generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class POASequenceGeneratorTest {

    private static final String EXPECTED_GENERATED_ID = "0005";

    @Test
    void testGenerateId() {
        var generator = new POASequenceGenerator();
        Assertions.assertEquals(EXPECTED_GENERATED_ID, generator.generateId(5));
    }
}
