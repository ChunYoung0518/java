package java8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalTest {

    @Test
    public void whenCreateAnEmpty_thenNotPresent() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void whenCreateWithSomething_thenPresent() {
        Optional<String> something = Optional.of("Something");
        assertTrue(something.isPresent());
    }

    @Test
    public void shouldThrowError_whenCreateWithNull() {
        assertThrows(NullPointerException.class, () -> {Optional.of(null);});
    }

    @Test
    public void shouldNotThrowError_whenCreateWithNullable() {
        Optional<String> something = Optional.ofNullable(null);
        assertFalse(something.isPresent());
    }

    @Test
    public void optionalBestPractice() {
        Optional<String> optional = Optional.of("Daniel");
        optional.ifPresent(name -> System.out.println(name.length()));
    }

    @Test
    public void givenOrElseValue_whenCreteWithNull_thenReturnTheValue() {
        String optional = (String) Optional.ofNullable(null).orElse("Daniel");
        assertEquals("Daniel", optional);
    }

    @Test
    public void whenCreateWithValue_thenGetTheValue() {
        Optional<String> optional = Optional.of("Daniel");
        assertEquals("Daniel", optional.get());
    }

}
