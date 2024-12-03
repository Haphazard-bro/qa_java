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

        // Создаем объект Lion
        Lion lion = new Lion(VALID_SEX_MALE, felineMock);

        // Проверяем результат
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testLionGetFood() throws Exception {
        // Настраиваем мок
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        // Создаем объект Lion
        Lion lion = new Lion(VALID_SEX_FEMALE, felineMock);

        // Проверяем результат
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void testLionInvalidSex() {
        // Проверяем выброс исключения с определенным сообщением
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(INVALID_SEX, felineMock);
        });

        // Проверяем сообщение исключения
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}