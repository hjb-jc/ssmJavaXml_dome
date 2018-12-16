package com.nf147.sim.entity;

public class Author {
    private Integer a_id;

    private String a_name;

    private String a_address;

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name == null ? null : a_name.trim();
    }

    public String getA_address() {
        return a_address;
    }

    public void setA_address(String a_address) {
        this.a_address = a_address == null ? null : a_address.trim();
    }

    @Override
    public String
    toString() {
        return "Author{" +
                "a_id=" + a_id +
                ", a_name='" + a_name + '\'' +
                ", a_address='" + a_address + '\'' +
                '}';
    }
}