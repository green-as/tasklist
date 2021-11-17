package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/*ほとんどの行はhibernateに接続するためのおまじないで
 * エクリプスのプロジェクト名を入れるところがあるだけ*/
public class DBUtil {
    private static final String tasklist = "tasklist";
    private static EntityManagerFactory emf;

    public static EntityManager createEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(tasklist);
        }

    return emf;
}
}
