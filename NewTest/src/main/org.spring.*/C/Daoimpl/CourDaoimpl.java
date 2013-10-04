package C.Daoimpl;

import C.InquiryBody.ClaInqcondition;
import C.InquiryReturn.InquReturn;
import C.dao.CourDao;
import C.model.Course;
import C.model.CourseName;
import C.model.CourseNum;
import MyException.MyException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import C.util.HibernateUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/19/13
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class CourDaoimpl extends HibernateDaoSupport implements CourDao {


    @Override
    public void update(Course cur) throws MyException {
        //To change body of implemented methods use File | Settings | File Templates.
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        try {
            session.update(cur);

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
    public void add(Course cur) throws MyException {
        //To change body of implemented methods use File | Settings | File Templates.
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        try {
            session.save(cur);
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
    public void delete(Course cur) throws MyException {
        //To change body of implemented methods use File | Settings | File Templates.
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        String hql = "delete Course as cur  where cur.id =?";
        try {
            Query queryupdate = session.createQuery(hql);
            queryupdate.setString(0, cur.getId());
            int ret = queryupdate.executeUpdate();

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
    public InquReturn inquiry(ClaInqcondition inq, int start, int limit) throws MyException {
        //To change body of implemented methods use File | Settings | File Templates.
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        InquReturn inqrtn = new InquReturn();

        StringBuilder hql1 = new StringBuilder("from Course as cur  ");
        Query query, query1;
        StringBuilder hql2 = new StringBuilder("select count(*) as count ");
        if (!inq.getKch().equals("") && !inq.getKcm().equals("null")) {
            hql1.append("where cur.id like:kch and ").append("cur.kcm like :kcm");

            query = session.createQuery(hql1.toString());
            query1 = session.createQuery(hql2.append(hql1).toString());
            query.setParameter("kch", "%"+inq.getKch()+"%");

            query1.setParameter("kch", "%"+inq.getKch()+"%");
            query.setParameter("kcm", "%"+inq.getKcm()+"%");
            query1.setParameter("kcm", "%"+inq.getKcm()+"%");


        } else if (!inq.getKch().equals("")) {
            hql1.append("where cur.id like :kch");
            query = session.createQuery(hql1.toString());
            query1 = session.createQuery(hql2.append(hql1).toString());

            query.setParameter("kch", "%"+inq.getKch()+"%");
            query1.setParameter("kch", "%"+inq.getKch()+"%");

        } else if (!inq.getKcm().equals("null")) {
            hql1.append("where cur.kcm like:kcm  ");
            query = session.createQuery(hql1.toString());
            query1 = session.createQuery(hql2.append(hql1).toString());
            query.setParameter("kcm", "%"+inq.getKcm()+"%");
            query1.setParameter("kcm", "%"+inq.getKcm()+"%");


        } else {

            query = session.createQuery(hql1.toString());
            query1 = session.createQuery(hql2.append(hql1).toString());


        }
        try {
            query.setFirstResult(start);
            query.setMaxResults(limit);
            inqrtn.setCur(query.list());

            int count = ((Number) query1.iterate().next()).intValue();
            inqrtn.setCount(count);
            trans.commit();
        } catch (HibernateException e) {
            if (trans != null)
                trans.rollback();

            e.printStackTrace();
            throw new MyException("inquiry");
        } finally {
            session.close();
        }


        return inqrtn;


    }

    @Override
    public InquReturn inquirycurnum() throws MyException {
        //To change body of implemented methods use File | Settings | File Templates.
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        InquReturn inqrtn = new InquReturn();

        StringBuilder hql1 = new StringBuilder("select cur.id from Course as cur  ");
        Query query;


        query = session.createQuery(hql1.toString());


        try {


            ArrayList<CourseNum> newlist = new ArrayList<CourseNum>();
            for (int i = 0; i < query.list().size(); i++) {
                CourseNum newone = new CourseNum();
                newone.setId(query.list().get(i).toString());
                newlist.add(newone);
            }
            inqrtn.setCurr(newlist);


            inqrtn.setCount(inqrtn.getCurr().size());
            trans.commit();
        } catch (HibernateException e) {
            if (trans != null)
                trans.rollback();

            e.printStackTrace();
            throw new MyException("inquiry");
        } finally {
            session.close();
        }


        return inqrtn;


    }

    @Override
    public List<CourseName> inquirycurname(String name) throws MyException {
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        List<CourseName> list = new ArrayList<CourseName>();
        List<String> temp = null;
        StringBuilder hql1 = new StringBuilder("select distinct cur.kcm from Course as cur ");
        Query query=null;

        if(name.equals("[]")){
            query = session.createQuery(hql1.toString());
        }

        else{

              query = session.createQuery(hql1.append("where cur.kcm like:kcm ").toString());
              query.setParameter("kcm","%"+name+"%");
        }
        try {



            temp = query.list();
            for (int i = 0; i < temp.size(); i++) {
                CourseName temp1 = new CourseName();
                temp1.setName(temp.get(i));
                list.add(temp1);
            }

            trans.commit();
        } catch (HibernateException e) {
            if (trans != null)
                trans.rollback();

            e.printStackTrace();
            throw new MyException("viewcurname");
        } finally {
            session.close();
        }


        return list;
    }
}
