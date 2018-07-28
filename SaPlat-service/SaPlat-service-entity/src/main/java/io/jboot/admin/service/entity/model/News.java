package io.jboot.admin.service.entity.model;

import io.jboot.db.annotation.Table;
import io.jboot.admin.service.entity.model.base.BaseNews;

/**
 * Generated by Jboot.
 */
@Table(tableName = "news", primaryKey = "id")
public class News extends BaseNews<News> {
	public String cstime;
	public String cetime;
	public String astime;
	public String aetime;

    public String getCstime() {
        return cstime;
    }

    public void setCstime(String cstime) {
        this.cstime = cstime;
    }

    public String getCetime() {
        return cetime;
    }

    public void setCetime(String cetime) {
        this.cetime = cetime;
    }

    public String getAstime() {
        return astime;
    }

    public void setAstime(String astime) {
        this.astime = astime;
    }

    public String getAetime() {
        return aetime;
    }

    public void setAetime(String aetime) {
        this.aetime = aetime;
    }
}
