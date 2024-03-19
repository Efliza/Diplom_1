import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    public IngredientType type;
    public String name;
    public float price;

    public IngredientTest (IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] data() {
        return new Object[][]{
                {SAUCE, "Горчичный", 30},
                {FILLING, "Коралл", 109}
        };
    }

    @Test
    public void ingredientTypeTest() {
        ingredient = new Ingredient(type, name, price);
        assertEquals("Ошибка! Такого типа ингредиента не существует", type, ingredient.getType());
    }

    @Test
    public void ingredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ошибка! Ингредиента с таким названием не существует.", name, ingredient.getName());
    }

    @Test
    public void ingredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ошибка! Ингредиента с такой ценой не существует.", price, ingredient.getPrice(), 0);
    }

}
