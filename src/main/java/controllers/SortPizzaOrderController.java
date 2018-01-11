package controllers;

import dao.PizzaOrdersImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortPizzaOrderController {
    @Value("${input.file}")
    private String inputPath;

    @Value("${output.file}")
    private String outputPath;

    private PizzaOrdersImpl pizzaOrdersImpl = new PizzaOrdersImpl();

    @Autowired
    private static Logger logger;

    @RequestMapping(value = "/pizza/sort")
    public void sortPizzaOrders() {
        logger.info("Processing the file from input path");
        pizzaOrdersImpl.sortPizzaOrders(inputPath, outputPath);
    }
}
