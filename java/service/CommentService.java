package service;

import entity.CommentEntity;

import java.util.List;

public interface CommentService {
    /**
     * 新增评论
     */
    public void add(CommentEntity commentEntity);

    /**
     * 显示评论列表
     */
    public List<CommentEntity> getComment();

    /**
     * 根据id显示评论
     */
    public CommentEntity findByID(int id);

    /**
     * 根据文章id显示评论列表
     */
    public List<CommentEntity> getByNovelId(int id);

    /**
     * 删除评论
     */
    public void delete(CommentEntity commentEntity);
}
