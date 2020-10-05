package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.util.PasswordUtil;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles = new ArrayList<Profile>();

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        Profile profile = new Profile();
        profile.setName("profile1");
        addProfile(profile);
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public Profile getFirstProfile() {
        return profiles.get(0);
    }

    public boolean verifyPassword(String password) {
        return PasswordUtil.isValid(password, this.password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
}
