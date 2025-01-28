package org.example.ocp.main;

import org.example.ocp.*;
import org.example.ocp.enums.Color;
import org.example.ocp.enums.Size;

import java.util.List;

public class OCPDemo {
    public static void main(String[] args) {
        System.out.println("Open Closed Principle");

        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        System.out.println("Green items:");
        ProductFilter productFilter = new ProductFilter();
        productFilter.filter(products, new ColorSpecification(Color.GREEN)).forEach(p -> System.out.println(p + " is green"));

        System.out.println("Large items:");
        productFilter.filter(products, new SizeSpecification(Size.LARGE)).forEach(p -> System.out.println(p + " is large"));

        System.out.println("Large green items:");
        productFilter.filter(products,
                new AndSpecification<>(
                        new ColorSpecification(Color.GREEN),
                        new SizeSpecification(Size.LARGE))).forEach(p -> System.out.println(" " + p + " is large and green"));
    }
}