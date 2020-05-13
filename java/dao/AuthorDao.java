package dao;
import entity.AuthorEntity;

import java.util.List;

public interface AuthorDao {

    /**
     * 注册新用户作为作者
     * @param authorEntity
     */
    public void add(AuthorEntity authorEntity);


    /**
     *登陆
     */
    public AuthorEntity login(AuthorEntity authorEntity);


    /**
     * 获取用户列表
     */
    public List<AuthorEntity> getAuthor();

    /**
     * 获取原创文章前十的用户
     */
    public List<AuthorEntity> getBest();

    /**
     * 根据账户名和密码查询
     */
    public AuthorEntity findByNameAndPass(AuthorEntity authorEntity);


    /**
     * 删除用户
     */
    public void delete(AuthorEntity authorEntity);

    /**
     * 更新用户信息
     */
    public void update(AuthorEntity authorEntity);

    /**
     * 根据id查询
     */
    public AuthorEntity findById(int id);

    /**
     * 根据用户名查询
     */
    public AuthorEntity findByName(String name);

}
