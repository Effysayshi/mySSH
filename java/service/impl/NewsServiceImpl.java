package service.impl;

import dao.NewsDao;
import entity.NewsEntity;
import org.springframework.transaction.annotation.Transactional;
import service.NewsService;

import java.util.List;

@Transactional
public class NewsServiceImpl  implements NewsService {

    private NewsDao newsDao;

    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public void add(NewsEntity newsEntity) {
        newsDao.add(newsEntity);
    }

    @Override
    public List<NewsEntity> getNews() {
        return newsDao.getNews();
    }

    @Override
    public NewsEntity findById(int id) {
        return newsDao.findById(id);
    }

    @Override
    public void delete(NewsEntity newsEntity) {
        newsDao.delete(newsEntity);
    }
}
