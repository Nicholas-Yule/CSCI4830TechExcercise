package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.TaskTable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UtilDBYule {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<TaskTable> listTasks() {
      List<TaskTable> resultList = new ArrayList<TaskTable>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> tasks = session.createQuery("FROM TaskTable").list();
         for (Iterator<?> iterator = tasks.iterator(); iterator.hasNext();) {
            TaskTable task = (TaskTable) iterator.next();
            resultList.add(task);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<TaskTable> listTasks(String keyword) {
      List<TaskTable> resultList = new ArrayList<TaskTable>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> tasks = session.createQuery("FROM TaskTable").list();
         for (Iterator<?> iterator = tasks.iterator(); iterator.hasNext();) {
            TaskTable task = (TaskTable) iterator.next();
            if (task.getName().startsWith(keyword)) {
               resultList.add(task);
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static void createTasks(String taskName, String category, String deadline, String priority) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new TaskTable(taskName, category, deadline, priority));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
}
