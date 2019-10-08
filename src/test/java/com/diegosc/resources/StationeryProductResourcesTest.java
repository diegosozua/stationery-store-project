package com.diegosc.resources;

import com.diegosc.api.StationeryProduct;
import com.diegosc.db.StationeryProductDao;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

public class StationeryProductResourcesTest {
    private static StationeryProductDao mockStationeryProductDao = Mockito.mock(StationeryProductDao.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new StationeryProductResources(mockStationeryProductDao))
            .build();

    @Test
    public void whenStationaryProductNotExistReturn404ById() {
        Mockito.when(mockStationeryProductDao.findById(20)).thenReturn(null);
        Response response = resources.client().target("/api/stationeries/20").request().get();

        Assert.assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }

    /*@Test
    public void whenStationaryProductExistReturn200() {
        StationeryProduct stationeryProduct = new StationeryProduct(
                1,
                "12345678901234",
                "Eraser",
                "A red/blue eraser",
                2,
                "eraser");
        Mockito.when(mockStationeryProductDao.findById(1)).thenReturn(stationeryProduct);
        Response response = resources.client().target("/api/stationeries/1").request().get();
        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }*/
}
