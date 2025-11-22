package com.examhub.examhub.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class SearchRequestTO implements Serializable {

    private static final long serialVersionUID = 9080407426651168569L;

    private int page;
    private int limit;

    private int firstLimit;
    private int endLimit;

    private SearchFieldsTO searchFields = null;
}
