package com.company.dictionaries.web.dictionaryvalue;

import com.company.dictionaries.entity.LocalizedValue;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.dictionaries.entity.DictionaryValue;
import com.haulmont.cuba.gui.components.CaptionMode;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DictionaryValueEdit extends AbstractEditor<DictionaryValue> {
    @Inject
    private Table<LocalizedValue> localeValuesTable;

    @Inject
    private CollectionDatasource<LocalizedValue, UUID> localeValuesDs;
    @Inject
    private Metadata metadata;

    @Named("fieldGroup.dictionary")
    private PickerField dictionaryField;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        // show code of dictionary
        dictionaryField.setCaptionProperty("code");
        dictionaryField.setCaptionMode(CaptionMode.PROPERTY);
    }

    @Override
    protected void postInit() {
        super.postInit();

        Map<String, String> localeMap = getItem().getLocaleMap();
        for (Map.Entry<String, String> entry : localeMap.entrySet()) {
            LocalizedValue localizedValue = metadata.create(LocalizedValue.class);
            localizedValue.setLocale(entry.getKey());
            localizedValue.setValue(entry.getValue());
            localeValuesDs.includeItem(localizedValue);
        }
    }

    public void addLocaleValue() {
        Editor editor = openEditor(metadata.create(LocalizedValue.class), WindowManager.OpenType.DIALOG);
        editor.addCloseWithCommitListener(() -> {
            LocalizedValue item = (LocalizedValue) editor.getItem();
            localeValuesDs.includeItem(item);

            // sync to entity
            Map<String, String> localeMap = new HashMap<>(getItem().getLocaleMap());
            localeMap.put(item.getLocale(), item.getValue());
            getItem().setLocaleMap(localeMap);
        });
    }

    public void removeLocaleValue() {
        LocalizedValue value = localeValuesTable.getSingleSelected();
        if (value != null) {
            localeValuesDs.excludeItem(value);

            // sync to entity
            Map<String, String> localeMap = new HashMap<>(getItem().getLocaleMap());
            localeMap.remove(value.getLocale());
            getItem().setLocaleMap(localeMap);
        }
    }
}