package com.examhub.examhub.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CommonListTO<T> {

    private Long totalRow;
    private Integer pageCount;
    private List<T> dataList = new ArrayList<>();


}
