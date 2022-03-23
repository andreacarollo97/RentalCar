package net.progetto.springmvc.dao;

import net.progetto.springmvc.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List <User> getUser() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < User > cq = cb.createQuery(User.class);
        Root < User > root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);
    }

    @Override
    public void saveUser(User theUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        if (theUser.getId() != null){
            currentSession.update(theUser);
        } else {
            currentSession.save(theUser);
        }
    }

    @Override
    public User getUser(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        User theUser = currentSession.get(User.class, theId);
        return theUser;
    }

    @Override
    public boolean validateUser(String username, String password) {
        return false;
    }

    @Override
    public User getUserByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root root = cq.from(User.class);
        cq.select(root).where(cb.equal(root.get("username"), username));
        Query query = currentSession.createQuery(cq);
        return (User) query.getSingleResult();
    }


}