package com.pathz.boot.rest.logging;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemLogger {
    private Map<String, String> loggerMessages = new HashMap<>();

    {
        loggerMessages.put("cheapestItemsGetSuccess", "Items was returned successfully");
        loggerMessages.put("cheapestItemsGetFail", "Request quantity is bigger than item quantity");
    }

    public void addMessage(String service, String message) {
        loggerMessages.put(service, message);
    }

}
