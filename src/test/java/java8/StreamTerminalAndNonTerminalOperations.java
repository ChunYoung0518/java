package java8;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class StreamTerminalAndNonTerminalOperations {

    /**
     * The terminal operations of the Java Stream interface typicall return a single value.
     */
    @Nested
    public class StreamTerminalOperations {

        List<String> list = Arrays.asList("ONE", "TWO", "THREE");

        @Test
        public void count() {
            assertEquals(3, list.stream().count());
        }

        @Test
        public void anyMatch() {
            assertTrue(list.stream().anyMatch(value -> value.equals("TWO")));
            assertFalse(list.stream().anyMatch(value -> value.equals("FOUR")));
        }

        @Test
        public void forEach() {
            list.stream().forEach(value -> System.out.println(value));
        }

        @Test
        public void min() {
            assertEquals("ONE", list.stream().min(Comparator.naturalOrder()).get());
        }

        @Test
        public void reduce() {
            assertEquals("ONE TWO THREE", list.stream().reduce((s1, s2) -> {return s1 + " " + s2;}).get());
        }
    }

    @Nested
    public class StreamNonTerminalOperations {

        List<String> list = Arrays.asList("ONE", "TWO", "THREE");

        @Test
        public void filter() {
            assertEquals(Arrays.asList("ONE", "TWO"), list.stream().filter(value -> value.contains("O")).collect(Collectors.toList()));
        }

        @Test
        public void map() {
            assertEquals(Arrays.asList("one", "two", "three"), list.stream().map(String::toLowerCase).collect(Collectors.toList()));
        }

        @Test
        public void distinct() {
            List<String> strings = new ArrayList<>();
            strings.add("ONE");
            strings.add("TWO");
            strings.add("THREE");
            strings.add("ONE");

            assertEquals(Arrays.asList("ONE", "TWO", "THREE", "ONE"), strings);
            assertEquals(Arrays.asList("ONE", "TWO", "THREE"), strings.stream().distinct().collect(Collectors.toList()));
        }
    }
}
