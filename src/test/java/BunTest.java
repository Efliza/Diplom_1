import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunNameTest() {
        return new Object[][] {
                {"Космическая булочка", 999},
                {null, 1799}
        };
    }

    @Test
    public void bunNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Ошибка! Булкочи с таким названием не существует.", name, bun.getName());
    }

    @Test
    public void bunPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Ошибка! Булочки с такой ценой не существует.", price, bun.getPrice(), 0);
    }

}
