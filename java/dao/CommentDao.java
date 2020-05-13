package dao;

import entity.CommentEntity;

import java.util.List;

public interface CommentDao {
    /**
     * 添加评论
     */
    public void add(CommentEntity commentEntity);

    /**
     * 获取评论列表
     */
    public List<CommentEntity> getComment();

    /**
     * 根据id查询评论
     */
    public CommentEntity findById(int id);

    /**
     * 根据文章id查询评论列表
     */
    public  List<CommentEntity> findByNovelId(int id);

    /**
     * 删除评论
     */
    public void delete(CommentEntity commentEntity);
}
