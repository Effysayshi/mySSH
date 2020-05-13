package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "news", schema = "ssh", catalog = "")
public class NewsEntity {
    private int id;
    private String newstitle;
    private String source;
    private String context;
    private Timestamp addtime;
    private byte[] photo;
    private String newsauthor;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "newstitle")
    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "context")
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Basic
    @Column(name = "addtime")
    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    @Basic
    @Column(name = "photo")
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "newsauthor")
    public String getNewsauthor() {
        return newsauthor;
    }

    public void setNewsauthor(String newsauthor) {
        this.newsauthor = newsauthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsEntity that = (NewsEntity) o;

        if (id != that.id) return false;
        if (newstitle != null ? !newstitle.equals(that.newstitle) : that.newstitle != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (context != null ? !context.equals(that.context) : that.context != null) return false;
        if (addtime != null ? !addtime.equals(that.addtime) : that.addtime != null) return false;
        if (!Arrays.equals(photo, that.photo)) return false;
        if (newsauthor != null ? !newsauthor.equals(that.newsauthor) : that.newsauthor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (newstitle != null ? newstitle.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (addtime != null ? addtime.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (newsauthor != null ? newsauthor.hashCode() : 0);
        return result;
    }
}
