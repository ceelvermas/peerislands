package io.peerislands;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 * A Builder class to build the sql query from json.
 */
public class QueryBuilder {

    private SqlQueryJson sqlQueryJson;

    public QueryBuilder(String fileName) {
        try {
            URL resource = getClass().getClassLoader().getResource(fileName);
            String jsonString = Files.readString(Path.of(resource.getPath()));

            ObjectMapper objectMapper = new ObjectMapper();
            this.sqlQueryJson = objectMapper.readValue(jsonString, SqlQueryJson.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String buildQuery() {
        StringBuilder query = new StringBuilder("select * from ");
        query.append(sqlQueryJson.getTableName());
        if (Objects.isNull(sqlQueryJson.getColumns()) || sqlQueryJson.getColumns().length == 0) {
            return query.toString();
        }

        int columnCount = 0;
        query.append(" where");
        for (QueryParameter parameter: sqlQueryJson.getColumns()) {
            if(columnCount == 0) {
                query.append(" ");
            } else {
                query.append(" and ");
            }

            query.append(parameter.getFieldName())
                    .append(" ")
                    .append(parameter.getOperator())
                    .append(" ")
                    .append(parameter.getFieldValue());
            columnCount++;
        }

        return query.toString();
    }
}
