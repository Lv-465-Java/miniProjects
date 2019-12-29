package com.softserve.dao.mapping;

import java.sql.ResultSet;

public interface Mapping<T> {
    T mapDataBaseRow(ResultSet resultSet);
}