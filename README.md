# localized-dictionaries

This demo project illustrates a simple approach of creating generic localizable dictionaries.

There are 2 main entities:

- Dictionary - logical dictionary with localized name
- DictionaryValue - value of dictionary with localized name

There is an additional non-persistent entity LocalizedValue, it is used only in CRUD UI of Dictionary/DictionaryValue.

Localized values are stored as JSON string in "localeNames" field of Dictionary / DictionaryValue entities.

Also, the project contains demo entity - Customer, it has relation to DictionaryValue. 
Users can set "country" of Customer using dictionary values with code "COUNTRY".
