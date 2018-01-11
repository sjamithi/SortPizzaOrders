package dao;

import models.Pizza;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaOrdersImpl {
    @Autowired
    private static Logger logger;

    public List<String> readFile(String input) {
        try {
            return Files.readAllLines(Paths.get(input));
        } catch (IOException e) {
            logger.error("Error while reading input file");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void writeFile(String outputPath, List<String> lines) {
        Path output = Paths.get(outputPath);
        try {
            Files.write(output, lines, StandardOpenOption.CREATE);
        } catch (IOException e) {
            logger.error("Error writing output file");
            e.printStackTrace();
        }
    }

    public List<Pizza> sortPizzaOrders(String inputPath, String outputPath) {
        List<Pizza> pizzaOrders = new ArrayList<>();
        try {

            List<String> lines = readFile(inputPath);
            String[] header = lines.get(0).split("\\s+");
            lines = lines.subList(1, lines.size());
            if (lines.size() == 0) {
                throw new Exception("No orders are taken");
            }

            for(String line: lines) {
                String[] orders = line.split("\\s+");
                Pizza pizza = new Pizza(orders[0], orders[1]);
                pizzaOrders.add(pizza);
            }
            Collections.sort(pizzaOrders);

            List<String> pizzaOutputs = pizzaOrders.stream().map(Pizza::getOutputString).collect(Collectors.toList());
            writeFile(outputPath, pizzaOutputs);

        } catch (Exception e) {
            logger.error("Exception found while trying to sort the orders");
        }
        return pizzaOrders;
    }
}
