package dao;

import entity.MagazineEntity;

import java.util.List;

public interface MagazineDao {

    /**
     *  新增杂志文章
     */
    public void add(MagazineEntity magazineEntity);

    /**
     * 显示杂志文章列表
     */
    public List<MagazineEntity> getMagazine();

    /**
     * 根据id查询
     */
    public MagazineEntity findById(int id);

    /**
     * 删除杂志文章
     */
    public void delete(MagazineEntity magazineEntity);
}
