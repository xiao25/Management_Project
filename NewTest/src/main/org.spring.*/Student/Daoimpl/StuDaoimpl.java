package Student.Daoimpl;


import MyException.MyException;
import Student.InquiryBody.Inqcondition;
import Student.InquiryReturn.InquiryReturn;
import Student.InquiryReturn.Stuname_Stuid;
import Student.dao.StuDao;
import Student.model.Student;
import Student.model.name_id;
import Student.util.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;


/**
 * Created with IntelliJ IDEA.
 * User: ghost
 * Date: 13-6-17
 * Time: �??8:48
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class StuDaoimpl extends HibernateDaoSupport implements StuDao {

    @Override
    public void add(Student stu) throws MyException {
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        try {
            session.save(stu);
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
    public void update(Student stu) throws MyException {
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        try {

            session.update(stu);
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
    public void delete(int id) throws MyException {
        //To change body of implemented methods use File | Settings | File Templates.
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();

        String hql = "delete Student as stu  where stu.id =?";
        try {
            Query queryupdate = session.createQuery(hql);
            queryupdate.setInteger(0, id);
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
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public InquiryReturn inquiry(Inqcondition inqcond, int start, int limit) throws MyException {
        //To change body of implemented methods use File | Settings | File Templates.
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        InquiryReturn inquiryreturn = new InquiryReturn();
        StringBuilder hql1 = new StringBuilder("from Student.model.Student as stu  ");
        Query query1, query2;
        int flag=0;
        int[] flags=new int[5];
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");

        StringBuilder hql2 = new StringBuilder("select count(*) as count ");

        if (inqcond.getStuname()!=null && !inqcond.getStuname().equals("") ) {

            hql1.append("where stu.stuname like:name  ");
                flag=1;

                 flags[0]=1;

        }
         if (!inqcond.getClassnum().equals("") && !inqcond.getClassnum().equals("6")) {
             if(flag==0)  {
            hql1.append("where stu.classnum like :classnum ");
             flag=1;
             }
            else
                 hql1.append("and stu.classnum like :classnum ");

             flags[1]=1;
        }
        if(!inqcond.getStunum().equals("")) {
            if(flag==0)   {
                hql1.append("where stu.stunum like :stunum ");
                flag=1;
            }
            else
                hql1.append("and stu.stunum like :stunum ");

            flags[2]=1;
        }
        if (inqcond.getBirthday1()!=null ) {
            if(flag==0)  {
                hql1.append("where stu.birthday >= :birthday1 ");
                flag=1;
            }
            else
                hql1.append("and stu.birthday  >= :birthday1 ");
            flags[3]=1;
        }




    if (inqcond.getBirthday2()!=null) {
        if(flag==0)  {
            hql1.append("where stu.birthday  <= :birthday2 ");
            flag=1;
        }
        else
            hql1.append("and stu.birthday <= :birthday2  ");
        flags[4]=1;
    }



        try {

            query1 = session.createQuery(hql1.toString());
            String hql22 = hql2.append(hql1).toString();
            query2 = session.createQuery(hql22);

            if(flags[0]==1){
                query1.setParameter("name", inqcond.getStuname());
                query2.setParameter("name", inqcond.getStuname());
            }
            if(flags[1]==1){
                query1.setParameter("classnum", inqcond.getClassnum());
                query2.setParameter("classnum",inqcond.getClassnum());
            }
            if(flags[2]==1){
                query1.setParameter("stunum",inqcond.getStunum());
                query2.setParameter("stunum",inqcond.getStunum());
            }
            if(flags[3]==1){

                query1.setParameter("birthday1",inqcond.getBirthday1());
                query2.setParameter("birthday1",inqcond.getBirthday1());
            }
            if(flags[4]==1){

                query1.setParameter("birthday2",inqcond.getBirthday2());
                query2.setParameter("birthday2",inqcond.getBirthday2());

            }

            query1.setFirstResult(start);
            query1.setMaxResults(limit);

            inquiryreturn.setStud(query1.list());
            int count = ((Number) query2.iterate().next()).intValue();
            inquiryreturn.setCount(count);
            trans.commit();
        } catch (HibernateException e) {
            if (trans != null)
                trans.rollback();

            e.printStackTrace();
            throw new MyException("inquiry");
        } finally {
            session.close();
        }
        return inquiryreturn;

    }

    @Override
    public List<name_id> viewidnames(String name) throws MyException {
        Session session = HibernateUtils.getSession();
        Transaction trans = session.beginTransaction();
        //String hql="select stu.id from Student as stu";
        List<name_id> stud = new ArrayList<name_id>();
        Query query2=null;
        StringBuilder hql1=new StringBuilder( "select stu.stuname from Student as stu ");
        try {
        if(name.equals("")||name.equals("[]")){

           query2= session.createQuery(hql1.toString());
        }
        else
        {

            query2 = session.createQuery(hql1.append("where  stu.stuname like :name").toString());
            query2.setParameter("name","%"+name+"%");
        }



            List<String> namesList = query2.list();


            for (int i = 0; i < namesList.size(); i++) {
                name_id nameid = new name_id();

                nameid.setStuname(namesList.get(i));
                stud.add(nameid);
            }


            trans.commit();
        }
        catch (HibernateException e) {
            if (trans != null)
                trans.rollback();

            e.printStackTrace();
            throw new MyException("viewidnames");
        }
        finally {
            session.close();
            return stud;
        }

    }
}
