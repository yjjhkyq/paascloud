package com.paascloud.provider.model.vo;

public class ExampleVo {
    private Long id;

    private String exampleFieldVarchar;

    private Integer exampleFieldInt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExampleFieldVarchar() {
        return exampleFieldVarchar;
    }

    public void setExampleFieldVarchar(String exampleFieldVarchar) {
        this.exampleFieldVarchar = exampleFieldVarchar == null ? null : exampleFieldVarchar.trim();
    }

    public Integer getExampleFieldInt() {
        return exampleFieldInt;
    }

    public void setExampleFieldInt(Integer exampleFieldInt) {
        this.exampleFieldInt = exampleFieldInt;
    }
}
