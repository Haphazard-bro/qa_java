import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.List;

public class CatTests {

    @Test
    public void testCatGetSound() {
        Feline felineMock = Mockito.mock(Feline.class);
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testCatGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Cat cat = new Cat(felineMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, cat.getFood());
    }
}