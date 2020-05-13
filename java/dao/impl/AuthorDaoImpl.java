package dao.impl;

import dao.AuthorDao;
import entity.AuthorEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl extends HibernateDaoSupport implements AuthorDao {

    @Override
    public AuthorEntity findByNameAndPass(AuthorEntity authorEntity) {
        String hql = "from AuthorEntity where authname = ? and authpassword = ?";
        List<AuthorEntity> list = this.getHibernateTemplate().find(hql,authorEntity.getAuthname(),authorEntity.getAuthpassword());
        if(list.size() > 0) {
            return list.get(0);
        }
            return null;
    }

    @Override
    public AuthorEntity findByName(String name) {
        String hql = "from AuthorEntity where authname = ?";
        List<AuthorEntity> list = this.getHibernateTemplate().find(hql,name);
        if(list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public AuthorEntity login(AuthorEntity authorEntity) {
        return null;
    }


    @Override
    public void add(AuthorEntity authorEntity) {
            this.getHibernateTemplate().save(authorEntity);

    }

    @Override
    public List<AuthorEntity> getAuthor() {
        String hql = "from AuthorEntity";
        List<?> authorList = getHibernateTemplate().find(hql);
        List<AuthorEntity> list = new ArrayList<>();

        for (int i = 0; i < authorList.size(); i++){
            list.add((AuthorEntity)authorList.get(i));
        }
        if (list.size() == 0)
            return null;
        else
            return list;
    }

    @Override
    public List<AuthorEntity> getBest() {
        String hql = "from AuthorEntity a order by a.sum desc ";

        List<?> authorList = getHibernateTemplate().find(hql);
        List<AuthorEntity> list = new ArrayList<>();

        for (int i = 0; i < 11; i++){
            list.add((AuthorEntity)authorList.get(i));
        }
        if (list.size() == 0)
            return null;
        else
            return list;

    }

    @Override
    public AuthorEntity findById(int id) {
        return this.getHibernateTemplate().get(AuthorEntity.class,id);
    }

    @Override
    public void update(AuthorEntity authorEntity) {
        this.getHibernateTemplate().update(authorEntity);
    }

    @Override
    public void delete(AuthorEntity authorEntity) {
        this.getHibernateTemplate().delete(authorEntity);
    }
}
