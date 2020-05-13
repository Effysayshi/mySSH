package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.MagazineEntity;
import service.MagazineService;

public class MagazineAction extends ActionSupport implements ModelDriven<MagazineEntity> {

    private MagazineEntity magazineEntity = new MagazineEntity();

    @Override
    public MagazineEntity getModel() {
        return magazineEntity;
    }

    private MagazineService magazineService;

    public void setMagazineService(MagazineService magazineService) {
        this.magazineService = magazineService;
    }

    public String findAll(){
        return null;
    }
}
