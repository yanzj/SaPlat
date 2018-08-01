package io.jboot.admin.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.admin.service.entity.model.InformationFill;

import java.util.List;


/**
 * @author ASUS
 */
public interface InformationFillService {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public InformationFill findById(Object id);


    /**
     * 通过权限id查询需要填写的资料信息
     * @param roleId 权限id
     * @return 集合
     */
    public List<InformationFill> findByRoleId(Long roleId);
    /**
     * find all model
     *
     * @return all <InformationFill
     */
    public List<InformationFill> findAll();


    /**
     * delete model by primary key
     *
     * @param id
     * @return success
     */
    public boolean deleteById(Object id);


    /**
     * delete model
     *
     * @param model
     * @return
     */
    public boolean delete(InformationFill model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(InformationFill model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(InformationFill model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(InformationFill model);


    public void join(Page<? extends Model> page, String joinOnField);

    public void join(Page<? extends Model> page, String joinOnField, String[] attrs);

    public void join(Page<? extends Model> page, String joinOnField, String joinName);

    public void join(Page<? extends Model> page, String joinOnField, String joinName, String[] attrs);

    public void join(List<? extends Model> models, String joinOnField);

    public void join(List<? extends Model> models, String joinOnField, String[] attrs);

    public void join(List<? extends Model> models, String joinOnField, String joinName);

    public void join(List<? extends Model> models, String joinOnField, String joinName, String[] attrs);

    public void join(Model model, String joinOnField);

    public void join(Model model, String joinOnField, String[] attrs);

    public void join(Model model, String joinOnField, String joinName);

    public void join(Model model, String joinOnField, String joinName, String[] attrs);

    public void keep(Model model, String... attrs);

    public void keep(List<? extends Model> models, String... attrs);
}