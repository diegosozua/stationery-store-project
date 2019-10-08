package com.diegosc.db;

import com.diegosc.api.StationeryProduct;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(StationeryProductMapper.class)
public interface StationeryProductDao {

    @SqlUpdate("INSERT INTO StationeryProduct (barcode, name, description, quantity, category) " +
               "VALUES (:barcode, :name, :description, :quantity, :category)")
    void insert(@BindBean StationeryProduct stationeryProduct);

    @SqlUpdate("UPDATE StationeryProduct SET " +
               "barcode = :sp.barcode, " +
               "name = :sp.name, " +
               "description = :sp.description, " +
               "quantity = :quantity, " +
               "category = :category " +
               "WHERE id = :sp.id")
    void update(@BindBean("sp") StationeryProduct stationeryProduct);

    @SqlQuery("SELECT * FROM StationeryProduct")
    List<StationeryProduct> getAllStationeryProducts();

    @SqlQuery("SELECT * FROM StationeryProduct WHERE id = :id")
    StationeryProduct findById(@Bind("id") int id);

    @SqlUpdate("DELETE FROM StationeryProduct WHERE id = :id")
    void deleteById(@Bind("id") int id);
}
