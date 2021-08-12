package com.example.portfolio.dao.customDao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.portfolio.dao.customDao.ProjectsCustomDao;
import com.example.portfolio.model.Projects;
import org.springframework.stereotype.Component;

@Component
public class ProjectsCustomDaoImpl implements ProjectsCustomDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Projects> findProjectsByParam(Map<String, String> params) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Projects> criteriaQuery = criteriaBuilder.createQuery(Projects.class);
		Root<Projects> projectsRoot = criteriaQuery.from(Projects.class);

		criteriaQuery.select(projectsRoot).where(setCriteriaParams(params, criteriaBuilder, projectsRoot).toArray(new Predicate[0]));

		return em.createQuery(criteriaQuery).getResultList();
	}

	private List<Predicate> setCriteriaParams(Map<String, String> params, CriteriaBuilder criteriaBuilder, Root<Projects> root) {
		List<Predicate> predicates = new ArrayList<>();

		for(Map.Entry entry: params.entrySet()) {
			if(entry.getValue() != null) {
				switch ((String) entry.getKey()) {
					case "user" : predicates.add(criteriaBuilder.equal(root.get((String)entry.getKey()).get("username"), entry.getValue()));
									break;
					default:		predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(root.get((String)entry.getKey())), ((String)entry.getValue()).toUpperCase()));
				}

			}
		}

		return predicates;
	}
}
