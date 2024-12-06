import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline felineMock;

    private static final String VALID_SEX_MALE = "Самец";
    private static final String VALID_SEX_FEMALE = "Самка";
    private static final String INVALID_SEX = "Некорректный пол";

    @Test
    public void testLionGetKittens() throws Exception {
        // Настраиваем мок
        when(felineMock.getKittens()).thenReturn(2);
        Lion lion = new Lion(VALID_SEX_MALE, felineMock);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testLionGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion(VALID_SEX_FEMALE, felineMock);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void testLionInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(INVALID_SEX, felineMock);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}