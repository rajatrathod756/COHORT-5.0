package org.example;

import org.example.impl.ChocolateFrosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class CakeBaker {
    private final Frosting frosting;
    private final Syrup syrup;

    public CakeBaker(Frosting frosting, Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake() {
        System.out.println("Cake created with : " + this.frosting.getFrostingType() + " and " + this.syrup.getSyrupType());
    }

}
