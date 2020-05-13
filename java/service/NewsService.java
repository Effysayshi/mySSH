package service;

import entity.NewsEntity;

import java.util.List;

public interface NewsService {
    /**
     * 增加新闻资讯
     */
    public void add(NewsEntity newsEntity);

    /**
     * 显示新闻资讯列表
     */
    public List<NewsEntity> getNews();

    /**
     * 根据id查看资讯
     */
    public NewsEntity findById(int id);

    /**
     * 删除资讯
     */
    public void delete(NewsEntity newsEntity);
}
