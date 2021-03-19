package ru;

import ru.Users;
import ru.Notes;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.HibernateSessionFactoryUtil;
import java.util.List;

public class UsersDAO {

    public Users findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }

    public void save(Users user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Users user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(Users user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
    public void update(Notes notes) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(notes);
        tx1.commit();
        session.close();
    }

    public void delete(Notes notes) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(notes);
        tx1.commit();
        session.close();
    }

    public Notes findNotesById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Notes.class, id);
    }

    public List<Users> findAll() {
        List<Users> users = (List<Users>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}