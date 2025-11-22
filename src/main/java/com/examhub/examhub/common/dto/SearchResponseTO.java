package com.examhub.examhub.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Setter
@Getter
public class SearchResponseTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int page;

    private int total;

    private List<T> list;
}