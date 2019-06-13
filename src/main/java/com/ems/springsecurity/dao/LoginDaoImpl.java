package com.ems.springsecurity.dao;

import com.ems.springsecurity.model.Login;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("loginDao")
public class LoginDaoImpl extends AbstractDao implements LoginDao {
    @Override
    public List<Login> findAllLogin() {
        CriteriaQuery<Login> q = getSession().getCriteriaBuilder().createQuery(Login.class);
        q.select(q.from(Login.class));
        TypedQuery<Login> tq = getSession().createQuery(q);
        return tq.getResultList();
    }

    @Override
    public Login findLoginByEmail(String email) {
        CriteriaBuilder b = getSession().getCriteriaBuilder();
        CriteriaQuery<Login> q = b.createQuery(Login.class);
        Root<Login> root = q.from(Login.class);
        Predicate p = b.like(root.join("employee").get("email"), email);
        q.select(root).where(p);
        TypedQuery<Login> tq = getSession().createQuery(q);
        return tq.getSingleResult();
    }
}
