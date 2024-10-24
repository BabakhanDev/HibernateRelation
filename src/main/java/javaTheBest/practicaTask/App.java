package javaTheBest.practicaTask;

import javaTheBest.practicaTask.config.DatabaseConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DatabaseConnection db = new DatabaseConnection();
        SessionFactory sessionFactory = db.getSessionFactory();

    }
}
