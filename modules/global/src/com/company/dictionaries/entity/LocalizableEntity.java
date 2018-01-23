package com.company.dictionaries.entity;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.UserSessionSource;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

public interface LocalizableEntity {
    // thread-safe instance of Gson for localeNames toJson/fromJson
    Gson gson = new Gson();

    String getCode();

    void setLocaleNames(String localeNames);
    String getLocaleNames();

    default Map<String, String> getLocaleMap() {
        if (getLocaleNames() == null) {
            return Collections.emptyMap();
        }

        Type type = new TypeToken<Map<String, String>>(){}.getType();
        return gson.fromJson(getLocaleNames(), type);
    }

    default void setLocaleMap(Map<String, String> localeMap) {
        if (!localeMap.isEmpty()) {
            Type type = new TypeToken<Map<String, String>>() {
            }.getType();
            this.setLocaleNames(gson.toJson(localeMap, type));
        } else {
            this.setLocaleNames(null);
        }
    }
}