package com.rabobank.chris.model.generator;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class POASequenceGeneratorTest {

    @Test
    void generate() {
        var generator = new POASequenceGenerator();
        assert "0005".equals(generator.generateId(5));
    }
}
