package dao;

import entity.NovelEntity;

import java.util.List;

public interface NovelDao {
    /**
     * 新增文章
     */
    public void add(NovelEntity novelEntity);

    /**
     * 获取文章列表
     */
    public List<NovelEntity> getNovel();

    /**
     * 根据点赞数取前十条
     */
    public List<NovelEntity> getBest();

    /**
     * 根据id查询
     */
    public NovelEntity findById(int id);

    /**
     * 根据标题查询
     */
    public NovelEntity findByTitle(String title);

    /**
     * 根据类型查询文章列表
     */
    public List<NovelEntity> getNovelByGenre(String genre);

    /**
     * 删除文章
     */
    public void delete(NovelEntity novelEntity);

    /**
     * 更新详细
     */
    public void update(NovelEntity novelEntity);
}
