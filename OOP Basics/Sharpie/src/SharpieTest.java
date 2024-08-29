import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharpieTest {
    Sharpie red;
    @BeforeEach
    void setUp() {
        red = new Sharpie("red", 20);
    }

    @Test
    void getColor() {
        assertEquals("red", red.getColor());
    }

    @Test
    void getWidth() {
        assertEquals(20, red.getWidth());
    }

    @Test
    void getInkAmount() {
        assertEquals(100, red.getInkAmount());
    }

    @Test
    void use() {
        assertEquals(100, red.getInkAmount());
        red.use();
        assertEquals(90, red.getInkAmount());
    }
}