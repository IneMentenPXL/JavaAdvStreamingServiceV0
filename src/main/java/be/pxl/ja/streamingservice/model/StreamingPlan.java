package be.pxl.ja.streamingservice.model;

import java.math.BigDecimal;

public enum StreamingPlan {
    BASIC(1, new BigDecimal("7.99")),
    STANDAARD(2, new BigDecimal("11.99")),
    PREMIUM(4, new BigDecimal("15.99"));

    private int numberOfProfiles;
    private BigDecimal price;

    StreamingPlan(int numberOfProfiles, BigDecimal price) {
        this.numberOfProfiles = numberOfProfiles;
        this.price = price;
    }

    public int getNumberOfProfiles() {
        return numberOfProfiles;
    }

    public void setNumberOfProfiles(int numberOfProfiles) {
        this.numberOfProfiles = numberOfProfiles;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
