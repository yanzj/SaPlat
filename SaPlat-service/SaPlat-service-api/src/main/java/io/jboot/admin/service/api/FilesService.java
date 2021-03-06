package io.jboot.admin.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.admin.service.entity.model.Files;

import java.util.List;

public interface FilesService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Files findById(Object id);


    /**
     * find all model
     *
     * @return all <Files
     */
    public List<Files> findAll();

    /**
     * 通过一个或者多个path查询
     * @param path path
     * @return 集合
     */
    public List<Files> findByPath(String ...path);

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
    public boolean delete(Files model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(Files model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(Files model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Files model);
    /**
     * save or update model
     *
     * @param model
     * @return save model
     */
    public Files saveAndGet(Files model);

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