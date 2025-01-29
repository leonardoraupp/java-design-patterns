package design.patterns.example.solid.ocp;

import design.patterns.example.solid.ocp.enums.Color;

public class ColorSpecification implements Specification<Product> {
    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == this.color;
    }
}
