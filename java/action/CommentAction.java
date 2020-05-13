package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.CommentEntity;
import service.CommentService;
import service.NovelService;

import java.sql.Timestamp;
import java.util.List;

public class CommentAction extends ActionSupport implements ModelDriven<CommentEntity> {

    private CommentEntity commentEntity = new CommentEntity();

    @Override
    public CommentEntity getModel() {
        return commentEntity;
    }

    private CommentService commentService;

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    private NovelService novelService;

    public void setNovelService(NovelService novelService) {
        this.novelService = novelService;
    }

    public String add(){
        //获取系统时间
        Timestamp t = new Timestamp(System.currentTimeMillis());
        commentEntity.setCommenttime(t);

        commentEntity.setNovel(novelService.findByTitle(commentEntity.getNovelname()));
        commentService.add(commentEntity);

        return "CommentAdd";
    }

    public String findAll(){
        List<CommentEntity> list = commentService.getComment();
        ActionContext.getContext().put("list",list);
        return "CommentShow";
    }

    public String delete(){
        commentEntity = commentService.findByID(commentEntity.getId());
        commentService.delete(commentEntity);
        return "CommentDelete";
    }
}
