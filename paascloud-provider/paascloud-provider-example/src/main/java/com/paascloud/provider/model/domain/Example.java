package com.paascloud.provider.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("example")
public class Example {
    @TableId
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