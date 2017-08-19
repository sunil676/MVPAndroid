package com.sunil.mvp.api.apiModel;

/**
 * Created by sunil on 12-08-2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KickStarterModel {

    @SerializedName("s.no")
    @Expose
    private Integer sNo;
    @SerializedName("amt.pledged")
    @Expose
    private Integer amtPledged;
    @SerializedName("blurb")
    @Expose
    private String blurb;
    @SerializedName("by")
    @Expose
    private String by;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("end.time")
    @Expose
    private String endTime;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("percentage.funded")
    @Expose
    private Integer percentageFunded;
    @SerializedName("num.backers")
    @Expose
    private String numBackers;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getSNo() {
        return sNo;
    }

    public void setSNo(Integer sNo) {
        this.sNo = sNo;
    }

    public Integer getAmtPledged() {
        return amtPledged;
    }

    public void setAmtPledged(Integer amtPledged) {
        this.amtPledged = amtPledged;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPercentageFunded() {
        return percentageFunded;
    }

    public void setPercentageFunded(Integer percentageFunded) {
        this.percentageFunded = percentageFunded;
    }

    public String getNumBackers() {
        return numBackers;
    }

    public void setNumBackers(String numBackers) {
        this.numBackers = numBackers;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}