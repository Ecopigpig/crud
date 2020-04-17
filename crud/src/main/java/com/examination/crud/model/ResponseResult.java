package com.examination.crud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = 3789181071351481900L;

    private Boolean msg;

    private Object data;

    private Long total;

}
