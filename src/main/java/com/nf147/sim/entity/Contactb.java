package com.nf147.sim.entity;

public class Contactb {
    private Integer c_id;

    private String c_name;

    private String c_address;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name == null ? null : c_name.trim();
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address == null ? null : c_address.trim();
    }
}