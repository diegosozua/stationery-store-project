package com.diegosc.db;

import com.diegosc.api.StationeryProduct;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StationeryProductMapper implements RowMapper<StationeryProduct> {
    @Override
    public StationeryProduct map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new StationeryProduct(
                rs.getInt("id"),
                rs.getString("barcode"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("quantity"),
                rs.getString("category")
        );
    }
}
