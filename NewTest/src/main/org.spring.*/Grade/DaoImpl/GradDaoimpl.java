package Grade.DaoImpl;

import Grade.InquiryReturn.InquReturn_Gra;
import Grade.dao.GradDao;
import Grade.model.Grade;
import MyException.MyException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import Grade.util.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/19/13
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class GradDaoimpl extends HibernateDaoSupport implements GradDao {

    @Override
    public void update(Grade grd) throws MyException {
        //To change body of implemented methods use File | Settings | File Templates.
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        try {
            session.update(grd);
            trans.commit();

        } catch (HibernateException e) {
            if (trans != null)
                trans.rollback();

            e.printStackTrace();
            throw new MyException("update");
        } finally {
            session.close();
        }

    }

    @Override
    public void create(Grade grd) throws MyException {
        //To change body of implemented methods use File | Settings | File Templates.
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        try {
            session.save(grd);
            trans.commit();


        } catch (HibernateException e) {
            if (trans != null)
                trans.rollback();

            e.printStackTrace();
            throw new MyException("add");
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Grade grd) throws MyException {
        //To change body of implemented methods use File | Settings | File Templates.
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        //this method will call an error with a temporary table
//        String hql = "delete Grade as grd  where grd.id=?";
//        try{
//        Query queryupdate = session.createQuery(hql);
//        queryupdate.setParameter(0, grd.getId());
//
//        int ret = queryupdate.executeUpdate();
//        trans.commit();
//
//        }
        try {
            session.delete(grd);
            trans.commit();
        } catch (HibernateException e) {
            if (trans != null)
                trans.rollback();

            e.printStackTrace();
            throw new MyException("delete");
        } finally {
            session.close();
        }

    }

    @Override
    public InquReturn_Gra inquiry(int id, int start, int limit) throws MyException {
        //To change body of implemented methods use File | Settings | File Templates.
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        String hql;
        StringBuilder hql2 = new StringBuilder("select count(*) as count ");
        InquReturn_Gra inqrtn = new InquReturn_Gra();
        if (id != 0)
            hql = "from Grade as grd where grd.id =?";

        else
            hql = "from Grade as grd ";
        try {
            Query query1 = session.createQuery(hql2.append(hql).toString());
            Query query = session.createQuery(hql);

            if (id != 0) {
                query.setParameter(0, id);
                query1.setParameter(0, id);
            }

            query.setFirstResult(start);
            query.setMaxResults(limit);
            inqrtn.setGrd(query.list());
            int count = ((Number) query1.iterate().next()).intValue();
            inqrtn.setCount(count);

            trans.commit();
        } catch (HibernateException e) {
            if (trans != null)
                trans.rollback();

            e.printStackTrace();
            throw new MyException("delete");
        } finally {
            session.close();
        }
        return inqrtn;

    }

    public InquReturn_Gra inquirystuname(ArrayList stuids, ArrayList kcms, int start, int limit) throws MyException {
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        InquReturn_Gra inqrtn = new InquReturn_Gra();


        Query query = null, query1 = null;
        StringBuilder hql2 = new StringBuilder("select count(*) as count ");


        //"


        StringBuilder hql1 = new StringBuilder("from Grade grd ");
        try {
//        if(kcms.get(0).equals("")&&stuids.get(0).equals(""))
//        {
//            query = session.createQuery(hql1.toString());
//            query1= session.createQuery(hql2.append(hql1).toString());
//        }
//            else if(kcms.get(0).equals("")){
//            hql1.append("where grd.student.stuname in (:argu)");
//            query = session.createQuery(hql1.toString());
//            query1= session.createQuery(hql2.append(hql1).toString());
//            query.setParameterList("argu",stuids);
//            query1.setParameterList("argu",stuids);
//
//        }
//            else if(stuids.get(0).equals("")){
//            hql1.append("where grd.course.kcm in (:argu1)") ;
//            query = session.createQuery(hql1.toString());
//            query1= session.createQuery(hql2.append(hql1).toString());
//            query.setParameterList("argu1",kcms);
//            query1.setParameterList("argu1",kcms);
//
//        }
//            else{
            hql1.append("where grd.student.stuname in (:argu) and grd.course.kcm in (:argu1)");

            query = session.createQuery(hql1.toString());
            query1 = session.createQuery(hql2.append(hql1).toString());

            query.setParameterList("argu", stuids);
            query1.setParameterList("argu", stuids);

            query.setParameterList("argu1", kcms);
            query1.setParameterList("argu1", kcms);

            // }


//            query.setFirstResult(start);
//            query.setMaxResults(limit);
            inqrtn.setGrd(query.list());

            int count = ((Number) query1.iterate().next()).intValue();
            inqrtn.setCount(count);
            trans.commit();
        } catch (HibernateException e) {
            if (trans != null)
                trans.rollback();

            e.printStackTrace();
            throw new MyException("inquirystuname");
        } finally {
            session.close();
        }

        return inqrtn;

    }

    public InquReturn_Gra inquirycourse(ArrayList kcms, int start, int limit) throws MyException {
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        InquReturn_Gra inqrtn = new InquReturn_Gra();

        StringBuilder hql1 = new StringBuilder("from Grade as grd ");
        Query query = null, query1 = null;
        StringBuilder hql2 = new StringBuilder("select count(*) as count ");

        try {

            if (kcms.get(0).equals("")) {

                query = session.createQuery(hql1.toString());
                query1 = session.createQuery(hql2.append(hql1).toString());
            } else {
                hql1.append(" where grd.course.kcm in (:argu)");


                query = session.createQuery(hql1.toString());


                query.setParameterList("argu", kcms);


                query1 = session.createQuery(hql2.append(hql1).toString());


                query1.setParameterList("argu", kcms);
            }

            query.setFirstResult(start);
            query.setMaxResults(limit);
            inqrtn.setGrd(query.list());

            int count = ((Number) query1.iterate().next()).intValue();
            inqrtn.setCount(count);
            trans.commit();
        } catch (HibernateException e) {
            if (trans != null)
                trans.rollback();

            e.printStackTrace();
            throw new MyException("inquirycourseid");
        } finally {
            session.close();
        }

        return inqrtn;

    }


}
