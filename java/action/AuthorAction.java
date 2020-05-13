package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.AuthorEntity;
import service.AuthorService;

import java.util.List;

public class AuthorAction extends ActionSupport implements ModelDriven<AuthorEntity> {

   private AuthorEntity authorEntity = new AuthorEntity();

    @Override
    public AuthorEntity getModel() {
        return authorEntity;
    }

    private AuthorService authorService;

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    //新增用户
    public String add(){
        System.out.println("action add"+authorEntity.getAuthname()+authorEntity.getAuthpassword());
        if(authorService.addAuthor(authorEntity)){
            System.out.println("service success");
            return LOGIN;
        }else{
            System.out.println("service error");
            return ERROR;
        }
    }

    //登录为管理员或用户
    public String login(){
        System.out.println("login action");
        //从数据库中查询是否存在用户
        AuthorEntity existAuthor = authorService.login(authorEntity);
        if(existAuthor == null){
            //如果没有，从数据库作者表中查询是否存在用户，存在返回author，并记录session
            this.addActionError("用户名或密码错误！");
            return INPUT;
        }else {
            //存在用户，保存session
            ActionContext.getContext().getSession().put("existAuthor",existAuthor);
            //若clazz为0则为管理员权限，进入后台管理首页
            if(existAuthor.getClazz().equals(0)) {
                return SUCCESS;
            }
            else {
                return "Author";
            }
        }
    }

    //查询所有用户，列表显示
    public String findAll(){
        System.out.println("findAll action");
        List<AuthorEntity> list = authorService.getAuthor();
        //存入值栈
        ActionContext.getContext().put("list",list);
        return "authorList";
    }

    //查看用户信息
    public String managerCheck(){
        //根据前台传值id查询数据库,getModel()
        authorEntity = authorService.findById(authorEntity.getId());
        return "AuthorProfile";
    }

    public String authorCheck(){
        //根据前台传值id查询数据库,getModel()
        authorEntity = authorService.findById(authorEntity.getId());
        return "AuthorInfo";
    }

    //更新用户信息
    public  String managerUpdate(){
        authorService.updateAuthor(authorEntity);
        return "ManagerUpdate";
    }

    public  String authorUpdate(){
        authorService.updateAuthor(authorEntity);
        return "AuthorUpdate";
    }

    //删除用户
    public String delete(){
        //先查询再删除能级联删除
        authorEntity = authorService.findById(authorEntity.getId());
        authorService.deleteAuthor(authorEntity);
        return "AuthorDelete";
    }

    public String getBest(){
        List<AuthorEntity> list = authorService.getBest();
        ActionContext.getContext().put("list",list);
        return "AuthorBest";
    }
}
