package io.jboot.admin.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.admin.service.entity.model.QuestionnaireContentLink;

import java.util.List;

public interface QuestionnaireContentLinkService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public QuestionnaireContentLink findById(Object id);


    /**
     * find all model
     *
     * @return all <QuestionnaireContentLink
     */
    public List<QuestionnaireContentLink> findAll();

    /**
     * 调查问卷ID查找属于问卷的内容ID
     * @param id
     * @return all QuestionnaireContentID
     */
    public Long[] findContentIdByQuestionnaireId(Long id);

    /**
     * delete model by primary key
     *
     * @param id
     * @return success
     */
    public boolean deleteById(Object id);

    /**
     * 根据调查内容id 查出关联id
     * @param contentId
     * @return all QuestionnaireContentID
     */
    public Long findIdByContentId(Long contentId);

    /**
     * delete model
     *
     * @param model
     * @return
     */
    public boolean delete(QuestionnaireContentLink model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(QuestionnaireContentLink model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(QuestionnaireContentLink model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(QuestionnaireContentLink model);


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