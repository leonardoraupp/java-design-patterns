package org.example.ocp;

import org.example.ocp.enums.Color;

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
