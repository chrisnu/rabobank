package com.rabobank.chris.model.generator;

import org.junit.jupiter.api.Test;

class POASequenceGeneratorTest {


    @Test
    void generate() {
        var generator = new POASequenceGenerator();
        assert "0005".equals(generator.generateId(5));
    }
}
