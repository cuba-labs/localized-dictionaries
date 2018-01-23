package com.company.dictionaries.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.core.global.UserSessionSource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;

@Table(name = "DICTIONARIES_DICTIONARY")
@Entity(name = "dictionaries$Dictionary")
@NamePattern("#getLocalizedName|localeNames,code")
public class Dictionary extends StandardEntity implements LocalizableEntity {
    private static final long serialVersionUID = -3986254385362380884L;

    @NotNull
    @Column(name = "CODE", nullable = false)
    protected String code;

    @OnDelete(DeletePolicy.DENY)
    @OneToMany(mappedBy = "dictionary")
    protected List<DictionaryValue> values;

    @Lob
    @Column(name = "LOCALE_NAMES")
    protected String localeNames;

    public void setValues(List<DictionaryValue> values) {
        this.values = values;
    }

    public List<DictionaryValue> getValues() {
        return values;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setLocaleNames(String localeNames) {
        this.localeNames = localeNames;
    }

    @Override
    public String getLocaleNames() {
        return localeNames;
    }

    @MetaProperty
    public String getLocalizedName() {
        UserSessionSource userSessionSource = AppBeans.get(UserSessionSource.class);

        Locale locale = userSessionSource.getLocale();
        String localeCode = locale.toLanguageTag();

        String localizedName = getLocaleMap().get(localeCode);
        if (localizedName != null) {
            return localizedName;
        }
        return getCode();
    }
}