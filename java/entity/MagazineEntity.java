package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "magazine", schema = "ssh", catalog = "")
public class MagazineEntity {
    private int id;
    private String magatitle;
    private String magawriter;
    private String book;
    private Timestamp addtime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "magatitle")
    public String getMagatitle() {
        return magatitle;
    }

    public void setMagatitle(String magatitle) {
        this.magatitle = magatitle;
    }

    @Basic
    @Column(name = "magawriter")
    public String getMagawriter() {
        return magawriter;
    }

    public void setMagawriter(String magawriter) {
        this.magawriter = magawriter;
    }

    @Basic
    @Column(name = "book")
    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Basic
    @Column(name = "addtime")
    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MagazineEntity that = (MagazineEntity) o;

        if (id != that.id) return false;
        if (magatitle != null ? !magatitle.equals(that.magatitle) : that.magatitle != null) return false;
        if (magawriter != null ? !magawriter.equals(that.magawriter) : that.magawriter != null) return false;
        if (book != null ? !book.equals(that.book) : that.book != null) return false;
        if (addtime != null ? !addtime.equals(that.addtime) : that.addtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (magatitle != null ? magatitle.hashCode() : 0);
        result = 31 * result + (magawriter != null ? magawriter.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (addtime != null ? addtime.hashCode() : 0);
        return result;
    }
}
