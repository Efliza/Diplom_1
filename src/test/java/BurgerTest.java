import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static Constants.Constants.BUN_PRICE;
import static Constants.Constants.MEET_PRICE;
import static Constants.Constants.SALAT_PRICE;
import static Constants.Constants.BURGER_NAME;
import static Constants.Constants.MEET_NAME;
import static Constants.Constants.SALAT_NAME;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    Bun bun;
    @Mock
    private Ingredient meet, salat, cheese;

    @Before
    public void newBurger() {

        burger = new Burger();
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(meet);
        burger.addIngredient(salat);

        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(meet.getPrice()).thenReturn(MEET_PRICE);
        Mockito.when(salat.getPrice()).thenReturn(SALAT_PRICE);

        float expected = BUN_PRICE * 2 + MEET_PRICE + SALAT_PRICE;
        float actualResult = burger.getPrice();

        assertEquals("Ошибка! Стоимость не верна!", expected, actualResult, 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(meet);
        burger.addIngredient(salat);

        Mockito.when(bun.getName()).thenReturn(BURGER_NAME);
        Mockito.when(meet.getName()).thenReturn(MEET_NAME);
        Mockito.when(salat.getName()).thenReturn(SALAT_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(meet.getPrice()).thenReturn(MEET_PRICE);
        Mockito.when(salat.getPrice()).thenReturn(SALAT_PRICE);
        Mockito.when(meet.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(salat.getType()).thenReturn(IngredientType.FILLING);

        String price = String.format("%f", BUN_PRICE * 2 + MEET_PRICE + SALAT_PRICE);

        String expectedResult = "(==== " + BURGER_NAME + " ====)\r\n" + "= sauce " + MEET_NAME + " =\r\n" + "= filling " + SALAT_NAME + " =\r\n" + "(==== " + BURGER_NAME + " ====)\r\n" + "\r\n" + "Price: " + price + "\r\n";
        String actualResult = burger.getReceipt();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(meet);
        burger.addIngredient(salat);
        burger.addIngredient(cheese);
        int expectedResult = 3;

        assertEquals(expectedResult, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(meet);
        burger.addIngredient(salat);
        burger.addIngredient(cheese);
        int indexForRemove = 1;
        burger.removeIngredient(indexForRemove);
        int expectedResult = 2;
        assertEquals(expectedResult, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(meet);
        burger.addIngredient(salat);
        burger.addIngredient(cheese);

        burger.moveIngredient(0, 2);
        assertEquals(salat, burger.ingredients.get(0));
        assertEquals(cheese, burger.ingredients.get(1));
    }
}