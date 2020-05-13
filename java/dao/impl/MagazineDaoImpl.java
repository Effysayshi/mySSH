package dao.impl;

import dao.MagazineDao;
import entity.MagazineEntity;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class MagazineDaoImpl extends HibernateDaoSupport implements MagazineDao {

    @Override
    public void add(MagazineEntity magazineEntity) {
        this.getHibernateTemplate().save(magazineEntity);
    }

    @Override
    public List<MagazineEntity> getMagazine() {
        String hql = "from MagazineEntity";
        List<?> magazineList = this.getHibernateTemplate().find(hql);
        List<MagazineEntity> list = new ArrayList<>();

        for (int i = 0; i < magazineList.size(); i++){
            list.add((MagazineEntity)magazineList.get(i));
        }
        if(list.size() == 0)
            return null;
        else
            return list;
    }

    @Override
    public MagazineEntity findById(int id) {
        return this.getHibernateTemplate().get(MagazineEntity.class,id);
    }

    @Override
    public void delete(MagazineEntity magazineEntity) {
        this.getHibernateTemplate().delete(magazineEntity);
    }
}
