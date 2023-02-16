package fr.natan.cleanarchitectureaddressms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CleanArchitectureAddressMsApplicationTests {
    @Test
    void contextLoad(){
        assertThat(TestContextLoader.test()).isNotNull();
    }

    static class TestContextLoader {
        public static String test(){
            return "test driven development";
        }
    }
}
