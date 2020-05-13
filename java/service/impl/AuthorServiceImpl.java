package service.impl;

import dao.AuthorDao;
import org.springframework.transaction.annotation.Transactional;
import service.AuthorService;
import entity.AuthorEntity;

import java.util.List;

@Transactional
public class AuthorServiceImpl implements AuthorService {
    private AuthorDao authorDao;

    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public boolean addAuthor(AuthorEntity authorEntity) {
        System.out.println("service add author");
        try{
            authorDao.add(authorEntity);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public AuthorEntity login(AuthorEntity authorEntity) {
        AuthorEntity existAuthor = authorDao.findByNameAndPass(authorEntity);
        return existAuthor;
    }

    @Override
    public List<AuthorEntity> getAuthor() {
        return authorDao.getAuthor();
    }

    @Override
    public List<AuthorEntity> getBest() {
        return authorDao.getBest();
    }

    @Override
    public AuthorEntity findById(int id) {
        return authorDao.findById(id);
    }

    @Override
    public AuthorEntity findByName(String name) {
        return authorDao.findByName(name);
    }

    @Override
    public void updateAuthor(AuthorEntity authorEntity) {
        authorDao.update(authorEntity);
    }

    @Override
    public void deleteAuthor(AuthorEntity authorEntity) {
        authorDao.delete(authorEntity);
    }
}
