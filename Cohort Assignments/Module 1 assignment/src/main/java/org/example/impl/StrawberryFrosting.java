package org.example.impl;

import org.example.Frosting;
import org.springframework.stereotype.Component;

@Component
public class StrawberryFrosting implements Frosting {
    @Override
    public String getFrostingType() {
        return "Strawberry Frosting";
    }
}
