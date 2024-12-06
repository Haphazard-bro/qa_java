import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class FelineTests {

    private static final String EXPECTED_FAMILY = "Кошачьи";
    private static final int DEFAULT_KITTENS_COUNT = 1;
    private static final int SPECIFIED_KITTENS_COUNT = 3;
    private static final List<String> EXPECTED_FOOD = List.of("Животные", "Птицы", "Рыба");

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals(EXPECTED_FOOD, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals(EXPECTED_FAMILY, feline.getFamily());
    }

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(DEFAULT_KITTENS_COUNT, feline.getKittens());
    }

    @Test
    public void testGetKittensWithArgument() {
        Feline feline = new Feline();
        assertEquals(SPECIFIED_KITTENS_COUNT, feline.getKittens(SPECIFIED_KITTENS_COUNT));
    }
}