package javaTheBest.lmsTask.config;

import javaTheBest.lmsTask.manytomany.Sportsmen;
import javaTheBest.lmsTask.manytomany.Traner;
import javaTheBest.lmsTask.onetomany.Game;
import javaTheBest.lmsTask.onetoone.Profil;
import javaTheBest.lmsTask.onetoone.User;
import javaTheBest.practicaTask.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DatabaseConnection {
    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.JAKARTA_JDBC_USER, "postgres");
        properties.put(Environment.JAKARTA_JDBC_PASSWORD, "postgres");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.FORMAT_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Traner.class);
        configuration.addAnnotatedClass(Sportsmen.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Profil.class);
        configuration.addAnnotatedClass(Game.class);
        return configuration.buildSessionFactory().unwrap(SessionFactory.class);
    }
}
