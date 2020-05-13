package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "novel", schema = "ssh", catalog = "")
public class NovelEntity {
    private int id;
    private String noveltitle;
    private String genre;
    private String novelwriter;
    private String novelcontext;
    private Timestamp writetime;
    private Integer vote;
    private String school;
    private AuthorEntity author;
    private Set<CommentEntity> comments;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "noveltitle")
    public String getNoveltitle() {
        return noveltitle;
    }

    public void setNoveltitle(String noveltitle) {
        this.noveltitle = noveltitle;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "novelwriter")
    public String getNovelwriter() {
        return novelwriter;
    }

    public void setNovelwriter(String novelwriter) {
        this.novelwriter = novelwriter;
    }

    @Basic
    @Column(name = "novelcontext")
    public String getNovelcontext() {
        return novelcontext;
    }

    public void setNovelcontext(String novelcontext) {
        this.novelcontext = novelcontext;
    }

    @Basic
    @Column(name = "writetime")
    public Timestamp getWritetime() {
        return writetime;
    }

    public void setWritetime(Timestamp writetime) {
        this.writetime = writetime;
    }

    @Basic
    @Column(name = "vote")
    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    @Basic
    @Column(name = "school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NovelEntity that = (NovelEntity) o;

        if (id != that.id) return false;
        if (noveltitle != null ? !noveltitle.equals(that.noveltitle) : that.noveltitle != null) return false;
        if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;
        if (novelwriter != null ? !novelwriter.equals(that.novelwriter) : that.novelwriter != null) return false;
        if (novelcontext != null ? !novelcontext.equals(that.novelcontext) : that.novelcontext != null) return false;
        if (writetime != null ? !writetime.equals(that.writetime) : that.writetime != null) return false;
        if (vote != null ? !vote.equals(that.vote) : that.vote != null) return false;
        if (school != null ? !school.equals(that.school) : that.school != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (noveltitle != null ? noveltitle.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (novelwriter != null ? novelwriter.hashCode() : 0);
        result = 31 * result + (novelcontext != null ? novelcontext.hashCode() : 0);
        result = 31 * result + (writetime != null ? writetime.hashCode() : 0);
        result = 31 * result + (vote != null ? vote.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "authorid", referencedColumnName = "id")
    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    @OneToMany(mappedBy = "novel")
    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }
}
