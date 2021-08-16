package java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamMapAndFlatMap {

    @Test
    public void map() {
        List<String> upper = Stream.of("a", "b", "c").map(String::toUpperCase).collect(Collectors.toList());
        assertEquals(Arrays.asList("A", "B", "C"), upper);
    }

    @Test
    public void flatMap() {
        List<String> flatList = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d")).stream()
                .flatMap(Collection::stream).collect(Collectors.toList());
        assertEquals(Arrays.asList("a", "b", "c", "d"), flatList);
    }

}
