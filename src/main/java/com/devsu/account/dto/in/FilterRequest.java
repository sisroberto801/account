package com.devsu.account.dto.in;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FilterRequest {
    private List<Integer> clientIds = new ArrayList<>();
    private String name;
    private Date startDate;
    private Date endDate;
}
