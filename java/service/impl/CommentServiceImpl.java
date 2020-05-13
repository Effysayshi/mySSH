package service.impl;

import dao.CommentDao;
import entity.CommentEntity;
import org.springframework.transaction.annotation.Transactional;
import service.CommentService;

import java.util.List;

@Transactional
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public void add(CommentEntity commentEntity) {
        commentDao.add(commentEntity);
    }

    @Override
    public List<CommentEntity> getComment() {
        return commentDao.getComment();
    }

    @Override
    public CommentEntity findByID(int id) {
        return commentDao.findById(id);
    }

    @Override
    public List<CommentEntity> getByNovelId(int id) {
        return commentDao.findByNovelId(id);
    }

    @Override
    public void delete(CommentEntity commentEntity) {
        commentDao.delete(commentEntity);
    }
}
