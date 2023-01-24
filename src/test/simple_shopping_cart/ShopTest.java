import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import simple_shopping_cart.Cart;
import simple_shopping_cart.Product;
import simple_shopping_cart.Shop;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);


    // Создаем набор продуктов для магазина:
    public static List<Product> getStoreItems() {
        List<Product> products = new ArrayList<>();
// Три массива Названия, Цены, Кол-во
        String[] productNames = {"bacon", "beef", "ham", "salmon", "carrot", "potato", "onion", "apple", "melon", "rice", "eggs", "yogurt"};
        Double[] productPrice = {170.00d, 250.00d, 200.00d, 150.00d, 15.00d, 30.00d, 20.00d, 59.00d, 88.00d, 100.00d, 80.00d, 55.00d};
        Integer[] stock = {10, 10, 10, 10, 10, 10, 10, 70, 13, 30, 40, 60};

// Последовательно наполняем список продуктами
        for (int i = 0; i < productNames.length; i++) {
            products.add(new Product(i + 1, productNames[i], productPrice[i], stock[i]));
        }

        return products;
    }


    private ByteArrayOutputStream output = new ByteArrayOutputStream();

        /**
         * 2.7. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
         * Пользователь вводит неверный номер продукта
         * <br><b>Ожидаемый результат:</b>
         * Исключение типа RuntimeException и сообщение Не найден продукт с id
         * *Сделать тест параметризованным
         */
        @ValueSource(ints = {13, 14})
        @ParameterizedTest
        void incorrectProductSelectionCausesException (int id) {

            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                cart.addProductToCartByID(id);
            });
            String exceptionMessage = String.format("Не найден продукт с id: %d ", id);
            String actualMessage = exception.getMessage();

            assertThat(actualMessage).isEqualTo(exceptionMessage);
        }
    }