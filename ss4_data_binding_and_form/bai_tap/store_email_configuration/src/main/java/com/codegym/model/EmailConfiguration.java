package com.codegym.model;
/*
    Created by Trinh Khai
    Date: 31/03/2022
    Time: 10:30
*/

public class EmailConfiguration {
    private Integer id;
    private String language;
    private Integer pageSize;
    private boolean spamsFilter;
    private String signature;

    public EmailConfiguration() {
    }

    public EmailConfiguration(Integer id, String language, Integer pageSize, boolean spamsFilter, String signature) {
        this.id = id;
        this.language = language;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "EmailConfiguration{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", pageSize=" + pageSize +
                ", spamsFilter=" + spamsFilter +
                ", signature='" + signature + '\'' +
                '}';
    }
}
