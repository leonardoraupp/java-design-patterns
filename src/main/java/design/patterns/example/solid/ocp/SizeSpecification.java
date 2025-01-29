package design.patterns.example.solid.ocp;

import design.patterns.example.solid.ocp.enums.Size;

public class SizeSpecification implements Specification<Product> {
    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == this.size;
    }
}
