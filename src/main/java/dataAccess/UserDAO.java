package dataAccess;

import org.example.Main;
import org.example.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class UserDAO {
    public static Configuration cfg = new Configuration().configure(Main.class.getClassLoader().getResource("hibernate.cfg.xml"));


    public static void insertUser(User user) {
        Transaction transaction = null;
        try (Session session = cfg.buildSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void deleteUser(User user) {
        Transaction transaction = null;
        try (Session session = cfg.buildSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public static User loadUser (int id) {
        Transaction transaction = null ;
        try (Session session = cfg.buildSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            User user1 = (User) session.get( User.class, id);
            transaction.commit();
            return user1 ;

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null ;
    }

    public static User serach (String name) {
        Transaction transaction = null ;
        try (Session session = cfg.buildSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            ScrollableResults results = session.createQuery("from User user").scroll(ScrollMode.FORWARD_ONLY);
            while (results.next()) {
                User user = (User) results.get(0);
                if (user.getName().equals(name)){
                    results.close();
                    return user ;
                }
            }
            results.close();
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

}
