package io.peerislands;

public class QueryBuilderTest {

    public static void main(String[] args) {
        QueryBuilder queryBuilder = new QueryBuilder("query.json");
        System.out.println(queryBuilder.buildQuery());
    }
}
