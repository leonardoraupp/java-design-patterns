package design.patterns.solid.ocp;

import design.patterns.solid.ocp.enums.Color;
import design.patterns.solid.ocp.enums.Size;

public class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "- " + name;
    }
}
