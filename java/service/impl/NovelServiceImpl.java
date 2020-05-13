package service.impl;

import dao.NovelDao;
import entity.NovelEntity;
import org.springframework.transaction.annotation.Transactional;
import service.NovelService;

import java.util.List;

@Transactional
public class NovelServiceImpl  implements NovelService {

    private NovelDao novelDao;

    public void setNovelDao(NovelDao novelDao) {
        this.novelDao = novelDao;
    }

    @Override
    public void add(NovelEntity novelEntity) {
        novelDao.add(novelEntity);
    }

    @Override
    public List<NovelEntity> getNovel() {
        return novelDao.getNovel();
    }

    @Override
    public List<NovelEntity> findByGenre(String genre) {
        return novelDao.getNovelByGenre(genre);
    }

    @Override
    public NovelEntity findByTitle(String title) {
        return novelDao.findByTitle(title);
    }

    @Override
    public NovelEntity findById(int id) {
        return novelDao.findById(id);
    }

    @Override
    public void delete(NovelEntity novelEntity) {
        novelDao.delete(novelEntity);
    }

    @Override
    public void update(NovelEntity novelEntity) {
        novelDao.update(novelEntity);
    }

    @Override
    public List<NovelEntity> getBest() {
        return novelDao.getBest();
    }
}
