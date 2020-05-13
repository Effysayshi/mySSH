package service.impl;

import dao.MagazineDao;
import entity.MagazineEntity;
import org.springframework.transaction.annotation.Transactional;
import service.MagazineService;

import java.util.List;

@Transactional
public class MagazineServiceImpl  implements MagazineService {

    private MagazineDao magazineDao ;

    public void setMagazineDao(MagazineDao magazineDao) {
        this.magazineDao = magazineDao;
    }

    @Override
    public void add(MagazineEntity magazineEntity) {
        magazineDao.add(magazineEntity);
    }

    @Override
    public MagazineEntity findById(int id) {
        return magazineDao.findById(id);
    }

    @Override
    public List<MagazineEntity> getMagazine() {
        return magazineDao.getMagazine();
    }

    @Override
    public void delete(MagazineEntity magazineEntity) {
        magazineDao.delete(magazineEntity);
    }
}
