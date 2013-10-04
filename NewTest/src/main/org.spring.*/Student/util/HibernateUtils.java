package Student.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/18/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtils {
    private static SessionFactory factory;

    static {
        try {
            //读�?hibernate.cfg.xml??��
            Configuration cfg = new Configuration().configure();

            //建�?SessionFactory
            factory = cfg.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //?��?�?????Session
    public static Session getSession() {
        return factory.openSession();
    }

    //?��?Session
    public static void closeSession(Session session) {
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
