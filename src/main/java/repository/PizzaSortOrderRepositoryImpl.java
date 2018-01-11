package repository;

import dao.PizzaOrdersImpl;
import models.Pizza;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaSortOrderRepositoryImpl {

   PizzaOrdersImpl pizzaOrders = new PizzaOrdersImpl();

    public void create(Pizza pizza) {

    }

    public List<Pizza> sortOrderResults() {
        return pizzaOrders.sortPizzaOrders("", "");
    }
}
