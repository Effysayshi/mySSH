package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment", schema = "ssh", catalog = "")
public class CommentEntity {
    private int id;
    private String commentauthor;
    private String commentcontext;
    private Timestamp commenttime;
    private String novelname;
    private NovelEntity novel;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "commentauthor")
    public String getCommentauthor() {
        return commentauthor;
    }

    public void setCommentauthor(String commentauthor) {
        this.commentauthor = commentauthor;
    }

    @Basic
    @Column(name = "commentcontext")
    public String getCommentcontext() {
        return commentcontext;
    }

    public void setCommentcontext(String commentcontext) {
        this.commentcontext = commentcontext;
    }

    @Basic
    @Column(name = "commenttime")
    public Timestamp getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Timestamp commenttime) {
        this.commenttime = commenttime;
    }

    @Basic
    @Column(name = "novelname")
    public String getNovelname() {
        return novelname;
    }

    public void setNovelname(String novelname) {
        this.novelname = novelname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (commentauthor != null ? !commentauthor.equals(that.commentauthor) : that.commentauthor != null)
            return false;
        if (commentcontext != null ? !commentcontext.equals(that.commentcontext) : that.commentcontext != null)
            return false;
        if (commenttime != null ? !commenttime.equals(that.commenttime) : that.commenttime != null) return false;
        if (novelname != null ? !novelname.equals(that.novelname) : that.novelname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (commentauthor != null ? commentauthor.hashCode() : 0);
        result = 31 * result + (commentcontext != null ? commentcontext.hashCode() : 0);
        result = 31 * result + (commenttime != null ? commenttime.hashCode() : 0);
        result = 31 * result + (novelname != null ? novelname.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "novelid", referencedColumnName = "id", nullable = false)
    public NovelEntity getNovel() {
        return novel;
    }

    public void setNovel(NovelEntity novel) {
        this.novel = novel;
    }
}
