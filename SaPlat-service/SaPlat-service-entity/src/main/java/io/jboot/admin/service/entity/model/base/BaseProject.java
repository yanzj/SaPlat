package io.jboot.admin.service.entity.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseProject<M extends BaseProject<M>> extends JbootModel<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}

	public void setSpell(java.lang.String spell) {
		set("spell", spell);
	}
	
	public java.lang.String getSpell() {
		return getStr("spell");
	}

	public void setUserId(java.lang.Long userId) {
		set("userId", userId);
	}
	
	public java.lang.Long getUserId() {
		return getLong("userId");
	}

	public void setRoleName(java.lang.String roleName) {
		set("roleName", roleName);
	}
	
	public java.lang.String getRoleName() {
		return getStr("roleName");
	}

	public void setAmount(java.lang.Double amount) {
		set("amount", amount);
	}
	
	public java.lang.Double getAmount() {
		return getDouble("amount");
	}

	public void setTypeID(java.lang.Long typeID) {
		set("typeID", typeID);
	}
	
	public java.lang.Long getTypeID() {
		return getLong("typeID");
	}

	public void setSite(java.lang.String site) {
		set("site", site);
	}
	
	public java.lang.String getSite() {
		return getStr("site");
	}

	public void setBrief(java.lang.String brief) {
		set("brief", brief);
	}
	
	public java.lang.String getBrief() {
		return getStr("brief");
	}

	public void setApproval(java.lang.String approval) {
		set("approval", approval);
	}
	
	public java.lang.String getApproval() {
		return getStr("approval");
	}

	public void setDrawings(java.lang.String drawings) {
		set("drawings", drawings);
	}
	
	public java.lang.String getDrawings() {
		return getStr("drawings");
	}

	public void setProposal(java.lang.String proposal) {
		set("proposal", proposal);
	}
	
	public java.lang.String getProposal() {
		return getStr("proposal");
	}

	public void setAssessmentMode(java.lang.String assessmentMode) {
		set("assessmentMode", assessmentMode);
	}
	
	public java.lang.String getAssessmentMode() {
		return getStr("assessmentMode");
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

	public void setStatus(java.lang.String status) {
		set("status", status);
	}
	
	public java.lang.String getStatus() {
		return getStr("status");
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
