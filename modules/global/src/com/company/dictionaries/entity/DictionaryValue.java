package com.company.dictionaries.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.UserSessionSource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Locale;

@Table(name = "DICTIONARIES_DICTIONARY_VALUE")
@Entity(name = "dictionaries$DictionaryValue")
@NamePattern("#getLocalizedName|localeNames,code")
public class DictionaryValue extends StandardEntity implements LocalizableEntity {
    private static final long serialVersionUID = -7743151089101146905L;

    @NotNull
    @Column(name = "CODE", nullable = false)
    protected String code;

    @Lob
    @Column(name = "LOCALE_NAMES")
    protected String localeNames;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DICTIONARY_ID")
    protected Dictionary dictionary;

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

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Dictionary getDictionary() {
        return dictionary;
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