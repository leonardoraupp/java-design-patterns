package design.patterns.example.solid.ocp;

import java.util.List;
import java.util.stream.Stream;

public class ProductFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(spec::isSatisfied);  // product -> spec.isSatisfied(product)
    }
}
