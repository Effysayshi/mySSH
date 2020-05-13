package dao.impl;

import dao.NovelDao;
import entity.NovelEntity;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class NovelDaoImpl extends HibernateDaoSupport implements NovelDao {

    @Override
    public void add(NovelEntity novelEntity) {
        this.getHibernateTemplate().save(novelEntity);
    }

    @Override
    public List<NovelEntity> getNovel() {
        String hql = "from NovelEntity";
        List<?> novelList = this.getHibernateTemplate().find(hql);
        List<NovelEntity> list = new ArrayList<>();

        for( int i = 0; i < novelList.size(); i++){
            list.add((NovelEntity)novelList.get(i));
        }
        if(list.size() == 0)
            return null;
        else
            return list;
    }

    @Override
    public List<NovelEntity> getBest() {
        String hql = "from NovelEntity n order by n.vote desc ";
        List<?> novelList = this.getHibernateTemplate().find(hql);
        List<NovelEntity> list = new ArrayList<>();

        for( int i = 0; i < 11; i++){
            list.add((NovelEntity)novelList.get(i));
        }
        if(list.size() == 0)
            return null;
        else
            return list;

    }

    @Override
    public NovelEntity findById(int id) {
        return this.getHibernateTemplate().get(NovelEntity.class,id);
    }

    @Override
    public NovelEntity findByTitle(String title) {
        String hql = "from NovelEntity where noveltitle = ?";
        List<NovelEntity> list = this.getHibernateTemplate().find(hql,title);
        if(list.size() > 0)
            return list.get(0);
        else
            return  null;

    }

    @Override
    public List<NovelEntity> getNovelByGenre(String genre) {
        String hql = "from NovelEntity where genre = ?";
        List<?> novelList = this.getHibernateTemplate().find(hql,genre);
        List<NovelEntity> list = new ArrayList<>();

        for( int i = 0; i < novelList.size(); i++){
            list.add((NovelEntity)novelList.get(i));
        }
        if(list.size() == 0)
            return null;
        else
            return list;
    }

    @Override
    public void delete(NovelEntity novelEntity) {
        this.getHibernateTemplate().delete(novelEntity);
    }

    @Override
    public void update(NovelEntity novelEntity) {
        this.getHibernateTemplate().update(novelEntity);
    }
}
