import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.Notes;
import ru.Users;
import ru.UsersService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;

import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        System.out.println("Выберите, с какой таблицей вы хотите работать:1-Пользователи;2-Заметки");
        Scanner c = new Scanner(System.in);
        Integer n = c.nextInt();
        switch (n) {
            case 1:
                System.out.println("Доступные действия: 1=редактирование 2=добавление 3=удаление");
                System.out.println("Выберите действие");
                Scanner y = new Scanner(System.in);
                Integer t = y.nextInt();
                switch (t){
                    case 1:
                        System.out.println("Выберите id для изменения");
                        Integer id = y.nextInt();
                        System.out.println("Введите ФИО");
                        String fio = y.next();
                        System.out.println("Введите номер");
                        String num = y.next();
                        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
                        UsersService userService = new UsersService();
                        Users user = new Users();
                        user.setIdusers(id);
                        user.setFio(fio);
                        user.setNumber(num);
                        userService.updateUser(user);
                        EntityManager entityManager = entityManagerFactory.createEntityManager();
                        entityManager.getTransaction().begin();
                        entityManager.getTransaction().commit();
                        entityManagerFactory.close();
                        y.close();
                        break;
                    case 2:
                        System.out.println("Введите id");
                        Integer id1 = y.nextInt();
                        System.out.println("Введите ФИО");
                        String fio1 = y.next();
                        System.out.println("Введите номер");
                        String num1 = y.next();
                        EntityManagerFactory entityManagerFactory1 = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
                        Users user1 = new Users();
                        user1.setIdusers(id1);
                        user1.setFio(fio1);
                        user1.setNumber(num1);
                        EntityManager entityManager1 = entityManagerFactory1.createEntityManager();
                        entityManager1.getTransaction().begin();
                        entityManager1.persist(user1);
                        entityManager1.getTransaction().commit();
                        entityManagerFactory1.close();
                        break;
                    case 3:
                        System.out.println("Выберите id для удаления");
                        Integer id2 = y.nextInt();
                        EntityManagerFactory entityManagerFactory2 = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
                        UsersService userService2 = new UsersService();
                        Users user2 = new Users();
                        user2.setIdusers(id2);
                        userService2.deleteUser(user2);
                        EntityManager entityManager2 = entityManagerFactory2.createEntityManager();
                        entityManager2.getTransaction().begin();
                        entityManager2.getTransaction().commit();
                        entityManagerFactory2.close();
                        y.close();
                        break;
                }
                break;
            case 2:
                System.out.println("Доступные действия: 1=редактирование 2=добавление 3=удаление");
                System.out.println("Выберите действие");
                Scanner u = new Scanner(System.in);
                Integer o = u.nextInt();
                switch (o){
                    case 1:
                        System.out.println("Выберите id для изменения");
                        Integer id4 = u.nextInt();
                        System.out.println("Введите название заметки");
                        String not1 = u.next();
                        System.out.println("Введите содержание заметки");
                        String con1 = u.next();
                        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
                        UsersService userService = new UsersService();
                        Notes notes = new Notes();
                        notes.setIdnotes(id4);
                        notes.setNotename(not1);
                        notes.setContent(con1);
                        userService.updateNotes(notes);
                        EntityManager entityManager = entityManagerFactory.createEntityManager();
                        entityManager.getTransaction().begin();
                        entityManager.getTransaction().commit();
                        entityManagerFactory.close();
                        u.close();
                        break;
                    case 2:
                        System.out.println("Введите id");
                        Integer id3 = u.nextInt();
                        System.out.println("Введите название заметки");
                        String not = u.next();
                        System.out.println("Введите содержание заметки");
                        String con = u.next();
                        EntityManagerFactory entityManagerFactory1 = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
                        Notes notes1 = new Notes();
                        notes1.setIdnotes(id3);
                        notes1.setNotename(not);
                        notes1.setContent(con);
                        EntityManager entityManager1 = entityManagerFactory1.createEntityManager();
                        entityManager1.getTransaction().begin();
                        entityManager1.persist(notes1);
                        entityManager1.getTransaction().commit();
                        entityManagerFactory1.close();
                        break;
                    case 3:
                        System.out.println("Выберите id для удаления");
                        Integer id6 = u.nextInt();
                        EntityManagerFactory entityManagerFactory2 = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
                        UsersService userService2 = new UsersService();
                        Notes notes2 = new Notes();
                        notes2.setIdnotes(id6);
                        userService2.deleteNotes(notes2);
                        EntityManager entityManager2 = entityManagerFactory2.createEntityManager();
                        entityManager2.getTransaction().begin();
                        entityManager2.getTransaction().commit();
                        entityManagerFactory2.close();
                        u.close();
                        break;
                }
                break;
        }
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}