package controller;

import dao.PizzaOrdersImpl;
import models.Pizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class SortOrdersController {
    @Value("${input.file}")
    private String inputPath;

    @Value("${output.file}")
    private String outputPath;

    private PizzaOrdersImpl pizzaOrdersImpl = new PizzaOrdersImpl();
    Logger logger = Logger.getLogger("HelloController");
    
    @RequestMapping(method = RequestMethod.GET, value="/sort")
    public List<Pizza> sortPizzaOrders() {
        logger.info("Processing the file from input path");
        return pizzaOrdersImpl.sortPizzaOrders(inputPath, outputPath);
    }
    
}
