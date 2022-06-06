package io.github.manuelernesto.money.api.repository.launch;

import io.github.manuelernesto.money.api.model.Launch;
import io.github.manuelernesto.money.api.repository.filter.LaunchFilter;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Ernesto (manuelernest0)
 * @version 1.0
 * @date 06/06/22 9:23 PM
 */
public class LaunchRepositoryQueryImpl implements LaunchRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Launch> filter(LaunchFilter filter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Launch> criteria = builder.createQuery(Launch.class);
        Root<Launch> root = criteria.from(Launch.class);

        Predicate[] predicates = createRestrictions(filter, builder, root);
        criteria.where(predicates);

        TypedQuery<Launch> query = manager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] createRestrictions(LaunchFilter filter, CriteriaBuilder builder, Root<Launch> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(filter.getDescription())) {
            var description = builder.like(builder.lower(root.get("description")), "%" + filter.getDescription() + "%");
            predicates.add(description);
        }
        if (filter.getDueDateFrom() != null) {
            var dueDate = builder.greaterThanOrEqualTo(root.get("dueDate"), filter.getDueDateFrom());
            predicates.add(dueDate);
        }
        if (filter.getDueDateTo() != null) {
            var dueDate = builder.lessThanOrEqualTo(root.get("dueDate"), filter.getDueDateTo());
            predicates.add(dueDate);
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
