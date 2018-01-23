package com.company.dictionaries.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.chile.core.annotations.NamePattern;

/**
 * Simple non-persistent entity for localized values UI
 */
@NamePattern("%s : %s|locale,value")
@MetaClass(name = "dictionaries$LocalizedValue")
public class LocalizedValue extends BaseUuidEntity {
    private static final long serialVersionUID = -3498837277949438697L;

    @NotNull
    @MetaProperty(mandatory = true)
    protected String locale;

    @NotNull
    @MetaProperty(mandatory = true)
    protected String value;

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLocale() {
        return locale;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}