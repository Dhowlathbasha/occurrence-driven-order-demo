package org.example.occurrence.driven.order.demo.client.order;

import feign.Headers;
import feign.RequestLine;
import io.micrometer.observation.annotation.Observed;
import org.example.occurrence.driven.order.demo.common.model.Order;

import java.util.Map;

@Observed
public interface OrderCommandClient {

    String BASE_PATH = "/api/v1/orders";

    @RequestLine("POST " + BASE_PATH)
    @Headers("Content-Type: application/json")
    Order create(Order order);

    @RequestLine("POST " + BASE_PATH + "/complete")
    @Headers("Content-Type: application/json")
    Map<String,String> complete(Order order);

}
