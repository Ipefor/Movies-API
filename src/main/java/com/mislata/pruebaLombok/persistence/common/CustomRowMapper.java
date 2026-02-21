package com.mislata.pruebaLombok.persistence.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mislata.pruebaLombok.common.locale.LanguageUtils;
import org.springframework.jdbc.core.RowMapper;

public interface CustomRowMapper<T> extends RowMapper<T> {

    default boolean existsColumn(ResultSet rs, String columnName) {

        try {
            rs.findColumn(columnName);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    default String getLanguage(){
        return LanguageUtils.getCurrentLanguage();
    }
}