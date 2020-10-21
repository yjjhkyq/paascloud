package com.paascloud.provider.model.dto;

import javax.validation.constraints.NotNull;

public class ExampleDto {
    private Long id;

    @NotNull(message = "字段不能为空")
    private String exampleFieldVarchar;

    @NotNull(message = "字段不能为空")
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
