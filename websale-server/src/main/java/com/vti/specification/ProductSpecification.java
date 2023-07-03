package com.vti.specification;

import com.vti.entity.Product;
import com.vti.form.ProductFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {
    public static Specification<Product> builSpec(ProductFilterForm form) {
        if (form == null) {
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            final List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(form.getSearch())) {
                String pattern = "%" + form.getSearch().trim() + "%";
                predicates.add(criteriaBuilder.or(
                        criteriaBuilder.like(root.get("name"), pattern),
                        criteriaBuilder.like(root.get("category").get("name"), pattern)
                ));
            }
            if (form.getMinprice() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("totalMembers"),
                        form.getMinprice()
                ));
            }
            if (form.getMaxprice() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(
                        root.get("totalMembers"),
                        form.getMaxprice()
                ));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
