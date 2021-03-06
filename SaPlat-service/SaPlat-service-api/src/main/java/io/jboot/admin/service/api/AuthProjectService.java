package io.jboot.admin.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.admin.service.entity.model.AuthProject;

import java.util.List;


/**
 * @author ASUS
 */
public interface AuthProjectService {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public AuthProject findById(Object id);


    /**
     * find model by primary key
     *
     * @param projectId
     * @return
     */
    public AuthProject findByProjectId(Object projectId);

    /**
     * find all model
     *
     * @return all <AuthProject
     */
    public List<AuthProject> findAll();


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
    public boolean delete(AuthProject model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(AuthProject model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(AuthProject model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(AuthProject model);

    public Page<AuthProject> findPage(AuthProject authProject, int pageNumber, int pageSize);

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