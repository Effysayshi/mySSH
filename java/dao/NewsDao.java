package dao;


import entity.NewsEntity;

import java.util.List;

public interface NewsDao {

    /**
     * 新增资讯新闻
     */
    public void add(NewsEntity newsEntity);

    /**
     * 获取资讯新闻列表
     */
    public List<NewsEntity> getNews();

    /**
     * 根据id查询
     */
    public NewsEntity findById(int id);

    /**
     * 删除资讯新闻
     */
    public void delete(NewsEntity newsEntity);
}
