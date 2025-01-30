package design.patterns.solid.ocp;

import design.patterns.solid.ocp.enums.Size;

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
