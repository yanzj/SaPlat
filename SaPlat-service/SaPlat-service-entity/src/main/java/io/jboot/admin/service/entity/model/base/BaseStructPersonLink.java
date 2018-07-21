package io.jboot.admin.service.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseStructPersonLink<M extends BaseStructPersonLink<M>> extends JbootModel<M> implements IBean {

    public void setID(java.lang.Long ID) {
        set("ID", ID);
    }

    public java.lang.Long getID() {
        return getLong("ID");
    }

    public void setStructID(java.lang.Long structID) {
        set("structID", structID);
    }

    public java.lang.Long getStructID() {
        return getLong("structID");
    }

    public void setPersonID(java.lang.Long personID) {
        set("personID", personID);
    }

    public java.lang.Long getPersonID() {
        return getLong("personID");
    }

    public void setCreateUserID(java.lang.Long createUserID) {
        set("createUserID", createUserID);
    }

    public java.lang.Long getCreateUserID() {
        return getLong("createUserID");
    }

    public void setCreateTime(java.util.Date createTime) {
        set("createTime", createTime);
    }

    public java.util.Date getCreateTime() {
        return get("createTime");
    }

    public void setLastUpdateUserID(java.lang.Long lastUpdateUserID) {
        set("lastUpdateUserID", lastUpdateUserID);
    }

    public java.lang.Long getLastUpdateUserID() {
        return getLong("lastUpdateUserID");
    }

    public void setLastAccessTime(java.util.Date lastAccessTime) {
        set("lastAccessTime", lastAccessTime);
    }

    public java.util.Date getLastAccessTime() {
        return get("lastAccessTime");
    }

    public void setSort(java.lang.Integer sort) {
        set("sort", sort);
    }

    public java.lang.Integer getSort() {
        return getInt("sort");
    }

    public void setRemark(java.lang.String remark) {
        set("remark", remark);
    }

    public java.lang.String getRemark() {
        return getStr("remark");
    }

    public void setIsEnable(java.lang.Integer isEnable) {
        set("isEnable", isEnable);
    }

    public java.lang.Integer getIsEnable() {
        return getInt("isEnable");
    }

}
