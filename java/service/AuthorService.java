package service;

import entity.AuthorEntity;

import java.util.List;

public interface AuthorService {
    /**
     * 注册用户
     * @param authorEntity
     * @return
     */
    public boolean addAuthor(AuthorEntity authorEntity);


    /**
     * 用户登陆
     */
    public AuthorEntity login(AuthorEntity authorEntity);

    /**
     * 显示用户列表
     */
    public List<AuthorEntity> getAuthor();

    /**
     * 显示原创前十用户
     */
    public List<AuthorEntity> getBest();

    /**
     * 编辑用户信息
     */
    public void updateAuthor(AuthorEntity authorEntity);

    /**
     * 删除用户信息
     */
    public void deleteAuthor(AuthorEntity authorEntity);

    /**
     * 根据id查询
     */
    public AuthorEntity findById(int id);

    /**
     * 根据用户名查询
     */
    public AuthorEntity findByName(String name);

}
