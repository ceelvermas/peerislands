package io.peerislands;

/**
 * A DTO class to represent table columns with applied operator and value
 */
public class QueryParameter {
    private String operator;
    private String fieldName;
    private String fieldValue;

    public QueryParameter() {}

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public String toString() {
        return "QueryParameter{" +
                "operator='" + operator + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldValue='" + fieldValue + '\'' +
                '}';
    }
}
