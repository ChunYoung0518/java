package java11;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptionalTest {

    @Test
    public void whenCreateWithNullable_thenIsEmptyIsTrue() {
        Optional empty = Optional.ofNullable(null);
        assertTrue(empty.isEmpty());
    }

    @Test
    public void whenCreateWithNonEmpty_thenIsEmptyIsFalse() {
        Optional empty = Optional.of("something");
        assertFalse(empty.isEmpty());
    }
}
