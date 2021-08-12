package com.example.portfolio.dao.customDao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import com.example.portfolio.dao.customDao.InterestsCustomDao;
import com.example.portfolio.model.Interests;
import com.example.portfolio.model.Projects;
import com.example.portfolio.model.Users;
import org.springframework.stereotype.Component;

@Component
public class InterestsCustomDaoImpl implements InterestsCustomDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public int getCountOfUsersForAnInterest(String interest) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Interests> criteriaQuery = criteriaBuilder.createQuery(Interests.class);
		Root<Interests> interestsRoot  = criteriaQuery.from(Interests.class);
		criteriaQuery.select(interestsRoot.get("users"));
		criteriaQuery.where(new Predicate[]{criteriaBuilder.equal(interestsRoot.get("interest"), interest)});

		return em.createQuery(criteriaQuery).getResultList().size();

	}
}
