package io.peerislands;

import java.util.Arrays;

/**
 * A DTO class to represent the json query.
 */
public class SqlQueryJson {
    private String tableName;
    private QueryParameter[] columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public QueryParameter[] getColumns() {
        return columns;
    }

    public void setColumns(QueryParameter[] columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "SqlQueryJson{" +
                "tableName='" + tableName + '\'' +
                ", columns=" + Arrays.toString(columns) +
                '}';
    }
}
