package service;

import entity.NovelEntity;

import java.util.List;

public interface NovelService {
    /**
     * 增加文章
     */
    public void add(NovelEntity novelEntity);

    /**
     * 显示文章列表
     */
    public List<NovelEntity> getNovel();

    /**
     * 显示前十文章列表
     */
    public List<NovelEntity> getBest();

    /**
     * 按照类型显示文章列表
     */
    public List<NovelEntity> findByGenre(String genre);

    /**
     * 根据id查询文章
     */
    public NovelEntity findById(int id);

    /**
     * 根据标题查询文章
     */
    public NovelEntity findByTitle(String title);

    /**
     * 删除文章
     */
    public void delete(NovelEntity novelEntity);

    /**
     * 更新文章详细
     */
    public void  update(NovelEntity novelEntity);
}
