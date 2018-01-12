package dao;

import models.Pizza;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PizzaOrdersImplTest {


    PizzaOrdersImpl pizzaOrders;

    @Before
    public void setUp() {
        pizzaOrders = Mockito.spy(new PizzaOrdersImpl());

    }

    @Test
    public void when_inputPath_alongWithOrdersAreGiven_thenSortTheOrders() {
        List<String> values = Arrays.asList("pizza ordertime", "pepporoni 123", "cheese 234");
        Mockito.doReturn(values).when(pizzaOrders).readFile(Mockito.anyString());
        Mockito.doNothing().when(pizzaOrders).writeFile(Mockito.anyString(), Mockito.anyList());
        List<Pizza> sorted = pizzaOrders.sortPizzaOrders("a", "b");
        Assert.assertEquals(values.get(2), sorted.get(0).getName() + " " + sorted.get(0).getOrderTime());
        Assert.assertEquals(values.get(1), sorted.get(1).getName() + " " + sorted.get(1).getOrderTime());
    }

    @Test(expected = Exception.class)
    public void when_inputPath_andNoOrdersAreGiven_thenExceptionThrown() {
        List<String> values = Arrays.asList("pizza ordertime");
        Mockito.doReturn(values).when(pizzaOrders).readFile(Mockito.anyString());
        pizzaOrders.sortPizzaOrders("a", "b");
    }
}
