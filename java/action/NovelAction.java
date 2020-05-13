package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.AuthorEntity;
import entity.CommentEntity;
import entity.NewsEntity;
import entity.NovelEntity;
import service.AuthorService;
import service.NewsService;
import service.NovelService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class NovelAction extends ActionSupport implements ModelDriven<NovelEntity> {

    private NovelEntity novelEntity = new NovelEntity();


    @Override
    public NovelEntity getModel() {
        return novelEntity;
    }

    private AuthorService authorService;

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    private NovelService novelService;

    public void setNovelService(NovelService novelService) {
        this.novelService = novelService;
    }

    private NewsService newsService;

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    public String add(){
        //获取系统时间
        Timestamp t = new Timestamp(System.currentTimeMillis());
        novelEntity.setWritetime(t);

        //获取session中保存的用户
        AuthorEntity authorEntity = (AuthorEntity)ActionContext.getContext().getSession().get("existAuthor");
        novelEntity.setAuthor(authorEntity);

        //文章计数
        int sum = authorEntity.getSum() + 1;
        authorEntity.setSum(sum);
        authorService.updateAuthor(authorEntity);

        //点赞数初始值为0
        novelEntity.setVote(0);

        novelService.add(novelEntity);
        return "NovelAdd";
    }

    public String showAll(){
        List<NovelEntity> novelList = novelService.findByGenre("小小说").subList(0,4);
        List<NovelEntity> poemList = novelService.findByGenre("诗歌").subList(0,4);
        List<NovelEntity> sanwenList = novelService.findByGenre("散文").subList(0,4);

        List<NewsEntity> newsList = newsService.getNews().subList(0,4);

        List<NovelEntity> bestNovel = novelService.getBest().subList(0,3);
        List<AuthorEntity> bestAuthor = authorService.getBest().subList(0,3);

        ActionContext.getContext().put("novelList",novelList);
        ActionContext.getContext().put("poemList",poemList);
        ActionContext.getContext().put("sanwenList",sanwenList);
        ActionContext.getContext().put("newsList",newsList);
        ActionContext.getContext().put("bestNovel",bestNovel);
        ActionContext.getContext().put("bestAuthor",bestAuthor);

        return "showAll";
    }

    public String vote(){
        novelEntity = novelService.findById(novelEntity.getId());
        Integer vote = novelEntity.getVote() + 1;
        novelEntity.setVote(vote);
        novelService.update(novelEntity);

        return "NovelVote";
    }

    public String getBest(){
        List<NovelEntity> list = novelService.getBest();
        ActionContext.getContext().put("list",list);
        return "NovelBest";
    }

    //用户查看小说，诗歌，散文，读后感列表
    public String authorFindN(){
        String genre = "小小说";
        List<NovelEntity> list = novelService.findByGenre(genre);
        ActionContext.getContext().put("list",list);
        return "NovelList";
    }

    public String authorFindP(){
        String genre = "诗歌";
        List<NovelEntity> list = novelService.findByGenre(genre);
        ActionContext.getContext().put("list",list);
        return "PoemList";
    }
    public String authorFindS(){
        String genre = "散文";
        List<NovelEntity> list = novelService.findByGenre(genre);
        ActionContext.getContext().put("list",list);
        return "SanwenList";
    }

    public String authorFindD(){
        String genre = "读后感";
        List<NovelEntity> list = novelService.findByGenre(genre);
        ActionContext.getContext().put("list",list);
        return "DuhouganList";
    }

    //管理员界面查看列表表
    public String managerFindN(){
        String genre = "小小说";
        List<NovelEntity> list = novelService.findByGenre(genre);
        ActionContext.getContext().put("list",list);
        return "NovelManage";
    }

    public String managerFindP(){
        String genre = "诗歌";
        List<NovelEntity> list = novelService.findByGenre(genre);
        ActionContext.getContext().put("list",list);
        return "PoemManage";
    }

    public String managerFindS(){
        String genre = "散文";
        List<NovelEntity> list = novelService.findByGenre(genre);
        ActionContext.getContext().put("list",list);
        return "SanwenManage";
    }

    public String managerFindD(){
        String genre = "读后感";
        List<NovelEntity> list = novelService.findByGenre(genre);
        ActionContext.getContext().put("list",list);
        return "DuhouganManage";
    }

    //用户查看文章详细
    public String authorCheckN(){
        novelEntity = novelService.findById(novelEntity.getId());
        Set<CommentEntity> comments = novelEntity.getComments();
        ActionContext.getContext().put("set",comments);
        return "NovelInfo";
    }

    public String authorCheckP(){
        novelEntity = novelService.findById(novelEntity.getId());
        Set<CommentEntity> comments = novelEntity.getComments();
        ActionContext.getContext().put("set",comments);
        return "PoemInfo";
    }

    public String authorCheckS(){
        novelEntity = novelService.findById(novelEntity.getId());
        Set<CommentEntity> comments = novelEntity.getComments();
        ActionContext.getContext().put("set",comments);
        return "SanwenInfo";
    }

    public String authorCheckD(){
        novelEntity = novelService.findById(novelEntity.getId());
        Set<CommentEntity> comments = novelEntity.getComments();
        ActionContext.getContext().put("set",comments);
        return "DuhouganInfo";
    }

    //管理员查看文章详细
    public String managerCheckN(){
        novelEntity = novelService.findById(novelEntity.getId());
        return "NovelCheck";
    }

    public String managerCheckP(){
        novelEntity = novelService.findById(novelEntity.getId());
        return "PoemCheck";
    }

    public String managerCheckS(){
        novelEntity = novelService.findById(novelEntity.getId());
        return "SanwenCheck";
    }

    public String managerCheckD(){
        novelEntity = novelService.findById(novelEntity.getId());
        return "DuhouganCheck";
    }

   //管理员删除小说
    public String deleteN(){
        novelEntity = novelService.findById(novelEntity.getId());
        novelService.delete(novelEntity);
        return "NovelDelete";
    }

    public String deleteP(){
        novelEntity = novelService.findById(novelEntity.getId());
        novelService.delete(novelEntity);
        return "PoemDelete";
    }

    public String deleteS(){
        novelEntity = novelService.findById(novelEntity.getId());
        novelService.delete(novelEntity);
        return "SanwenDelete";
    }

    public String deleteD(){
        novelEntity = novelService.findById(novelEntity.getId());
        novelService.delete(novelEntity);
        return "DuhouganDelete";
    }





}
