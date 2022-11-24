package com.huangzq.baiwei.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResult<T> {
    private boolean success;
    private String msg;
    private Object data;
    private List<T> result;
    private int total;
}
