package org.example.occurrence.driven.order.demo.client.order.decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.example.occurrence.driven.order.demo.client.order.exception.BadRequestException;
import org.example.occurrence.driven.order.demo.client.order.exception.ResourceNotFoundException;
import org.example.occurrence.driven.order.demo.client.order.model.ResourceName;

@RequiredArgsConstructor
public class CustomErrorDecoder implements ErrorDecoder {

    private final ResourceName resourcesName;

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException("invalid input for" + methodKey + ":" + resourcesName.name());
            case 404:
                return new ResourceNotFoundException(resourcesName.name() + " not found.");
            default:
                return new Exception("Exception while getting product details");
        }
    }

}
