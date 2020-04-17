package com.examination.crud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageParam implements Serializable {

    private static final long serialVersionUID = 2490614320553422404L;

    private int page;

    private int size;
}
