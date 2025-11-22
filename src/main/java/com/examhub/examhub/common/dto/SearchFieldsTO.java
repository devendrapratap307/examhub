package com.examhub.examhub.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class SearchFieldsTO implements Serializable {

    private static final long serialVersionUID = 2909494450651767609L;

    private String searchField;
    private String searchFor;
}