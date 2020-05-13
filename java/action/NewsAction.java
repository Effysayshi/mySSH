package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.NewsEntity;
import service.NewsService;

import java.sql.Timestamp;
import java.util.List;

public class NewsAction extends ActionSupport implements ModelDriven<NewsEntity> {

    private NewsEntity newsEntity = new NewsEntity();
    private NewsService newsService;

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    public NewsEntity getModel() {
        return newsEntity;
    }

    public String managerCheck(){
        newsEntity = newsService.findById(newsEntity.getId());
        return "NewsCheck";
    }



    //管理员增加新闻资讯
    public String add(){
        //获取当前系统时间
        Timestamp d = new Timestamp(System.currentTimeMillis());
        newsEntity.setAddtime(d);
        newsService.add(newsEntity);
        return "NewsAdd";
    }

    //管理员界面列表显示所有资讯
    public String managerFindAll(){
        List<NewsEntity> list = newsService.getNews();
        ActionContext.getContext().put("list",list);
        return "NewsManager";
    }

    //管理员界面列表显示所有资讯
    public String authorFindAll(){
        List<NewsEntity> list = newsService.getNews();
        ActionContext.getContext().put("list",list);
        return "NewsList";
    }



    public String authorCheck(){
        newsEntity = newsService.findById(newsEntity.getId());
        return "NewsInfo";
    }

    //删除资讯
    public String delete(){
        newsEntity = newsService.findById(newsEntity.getId());
        newsService.delete(newsEntity);
        return "NewsDelete";
    }

}
