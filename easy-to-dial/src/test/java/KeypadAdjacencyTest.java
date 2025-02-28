import org.example.KeypadAdjacency;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeypadAdjacencyTest {

    @Test
    public void testBuildsAdjacencyMapCorrectly() {
        Map<Integer, Set<Integer>> expected = new HashMap<>() {{
            put(1, Set.of(1, 2, 4, 5));
            put(2, Set.of(1, 2, 3, 4, 5, 6));
            put(3, Set.of(2, 3, 5, 6));
            put(4, Set.of(1, 2, 4, 5, 7, 8));
            put(5, Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
            put(6, Set.of(2, 3, 5, 6, 8, 9));
            put(7, Set.of(4, 5, 7, 8, 0));
            put(8, Set.of(4, 5, 6, 7, 8, 9, 0));
            put(9, Set.of(5, 6, 8, 9, 0));
            put(0, Set.of(7, 8, 9, 0));
        }};

        var actual = KeypadAdjacency.buildAdjacencyMap();
        assertEquals(expected, actual);
    }
}
