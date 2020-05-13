package dao.impl;


import dao.NewsDao;
import entity.NewsEntity;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends HibernateDaoSupport implements NewsDao {

    @Override
    public void add(NewsEntity newsEntity) {
        this.getHibernateTemplate().save(newsEntity);
    }

    @Override
    public List<NewsEntity> getNews() {
        String hql = "from NewsEntity";
        List<?> newsList = this.getHibernateTemplate().find(hql);
        List<NewsEntity> list = new ArrayList<>();

        for( int i = 0 ; i < newsList.size() ; i++ ){
            list.add((NewsEntity)newsList.get(i));
        }
        if (list.size() == 0)
            return null;
        else
            return list;

    }

    @Override
    public NewsEntity findById(int id) {
        return this.getHibernateTemplate().get(NewsEntity.class,id);
    }

    @Override
    public void delete(NewsEntity newsEntity) {
        this.getHibernateTemplate().delete(newsEntity);
    }
}
