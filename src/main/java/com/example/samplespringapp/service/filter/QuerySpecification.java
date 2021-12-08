package com.example.samplespringapp.service.filter;

import com.example.samplespringapp.exception.CustomException;
import com.example.samplespringapp.model.filter.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class QuerySpecification<T> implements Specification<T> {

    private List<SearchCriteria> criteriaList;

    public QuerySpecification() {
        this.criteriaList = new ArrayList<>();
    }

    public QuerySpecification(List<SearchCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    public void add(SearchCriteria criteria) {
        criteriaList.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : criteriaList) {
            switch (criteria.getOperation()) {
                case GREATER_THAN:
                    predicates.add(
                            builder
                                    .greaterThan(root.get(criteria.getKey()),
                                    criteria.getValue().toString()));
                    break;
                case LESS_THAN:
                    predicates.add(
                            builder
                                    .lessThan(root.get(criteria.getKey()),
                                    criteria.getValue().toString()));
                    break;
                case GREATER_THAN_EQUAL:
                    predicates.add(
                            builder
                                    .greaterThanOrEqualTo(root.get(criteria.getKey()),
                                    criteria.getValue().toString()));
                    break;
                case LESS_THAN_EQUAL:
                    predicates.add(
                            builder
                                    .lessThanOrEqualTo(root.get(criteria.getKey()),
                                    criteria.getValue().toString()));
                    break;
                case NOT_EQUAL:
                    predicates.add(
                            builder
                                    .notEqual(root.get(criteria.getKey()),
                                            criteria.getValue()));
                    break;
                case EQUAL:
                    predicates.add(
                            builder
                                    .equal(root.get(
                                    criteria.getKey()), criteria.getValue()));
                    break;
                case MATCH:
                    predicates.add(
                            builder
                                    .like(builder.lower(root.get(criteria.getKey()))
                                    , "%" + criteria.getValue().toString().toLowerCase() + "%"));
                    break;
                case MATCH_END:
                    predicates.add(
                            builder
                                    .like(builder.lower(root.get(criteria.getKey())),
                                    criteria.getValue().toString().toLowerCase() + "%"));
                    break;
                case MATCH_START:
                    predicates.add
                            (builder
                                    .like(builder.lower(root.get(criteria.getKey())),
                                    "%" + criteria.getValue().toString().toLowerCase()));
                    break;
                case IN:
                    predicates.add(
                            builder
                                    .in(root.get(criteria.getKey())).value(criteria.getValue()));
                    break;
                case NOT_IN:
                    predicates.add(
                            builder
                                    .not(root.get(criteria.getKey()))
                                    .in(criteria.getValue()));
                    break;
                default:
                    throw new CustomException("Błąd podczas filtrowania, spróbuj ponownie. Sprawdź poprawność wpisanych kryterów filtrowania!");
            }
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
