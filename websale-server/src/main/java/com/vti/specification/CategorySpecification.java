package com.vti.specification;

import com.vti.entity.Category;
import com.vti.form.CategoryFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CategorySpecification {
    public static Specification<Category> buildSpec(CategoryFilterForm form) {
        if (form == null) {
            return null;
        }
        return (root, query, builder) -> {
            final List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(form.getSearch())) {
                String pattern = "%" + form.getSearch().trim() + "%";
                predicates.add(
                        builder.like(root.get("name"), pattern)
                );
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
