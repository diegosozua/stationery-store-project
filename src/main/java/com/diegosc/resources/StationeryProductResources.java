package com.diegosc.resources;

import com.diegosc.api.StationeryProduct;
import com.diegosc.db.StationeryProductDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("stationeries")
@Produces(MediaType.APPLICATION_JSON)
public class StationeryProductResources {
    private StationeryProductDao stationeryProductDao;

    public StationeryProductResources(StationeryProductDao stationeryDao) {
        this.stationeryProductDao = stationeryDao;
    }

    @GET
    public Response getAllStationeryProducts() {
        List<StationeryProduct> allStationeryProducts = stationeryProductDao.getAllStationeryProducts();
        return Response.ok(allStationeryProducts).build();
    }

    @POST
    public Response createStationeryProduct(StationeryProduct stationeryProduct) {
        stationeryProductDao.insert(stationeryProduct);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response updateStationeryProduct(StationeryProduct stationeryProduct) {
        stationeryProductDao.update(stationeryProduct);
        return Response.ok(stationeryProduct).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStationeryProduct(@PathParam("id") int id) {
        if(stationeryProductDao.findById(id) != null){
            stationeryProductDao.deleteById(id);
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(stationeryProductDao).build();
    }

    @GET
    @Path("/{id}")
    public Response getStationeryProductById(@PathParam("id") int id) {
        StationeryProduct stationeryProduct = stationeryProductDao.findById(id);

        if(stationeryProduct == null)
            throw new WebApplicationException("Stationery product not found", Response.Status.NOT_FOUND);
        return Response.ok(stationeryProduct).build();
    }
}
