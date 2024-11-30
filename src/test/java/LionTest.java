import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline felineMock;

    @Test
    public void testLionGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testLionGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test(expected = Exception.class)
    public void testLionInvalidSex() throws Exception {
        new Lion("Некорректный пол", felineMock);
    }
}