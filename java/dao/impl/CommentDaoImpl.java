package dao.impl;

import dao.CommentDao;
import entity.CommentEntity;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao {
    @Override
    public void add(CommentEntity commentEntity) {
        this.getHibernateTemplate().save(commentEntity);
    }

    @Override
    public List<CommentEntity> getComment() {
        String hql = "from CommentEntity";
        List<?> CommnetList = this.getHibernateTemplate().find(hql);
        List<CommentEntity> list = new ArrayList<>();

        for(int i = 0; i < CommnetList.size(); i++){
            list.add((CommentEntity)CommnetList.get(i));
        }
        if (list.size() == 0)
            return null;
        else
            return list;

    }

    @Override
    public CommentEntity findById(int id) {
        return this.getHibernateTemplate().get(CommentEntity.class,id);
    }

    @Override
    public List<CommentEntity> findByNovelId(int id) {
        return null;
    }

    @Override
    public void delete(CommentEntity commentEntity) {
        this.getHibernateTemplate().delete(commentEntity);
    }
}
