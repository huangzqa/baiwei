package com.huangzq.baiwei.result;

import java.util.List;

public class DataResult <T> {
    private boolean success;
    private Integer code;
    private String msg;
    private List<T> result;

    public DataResult() {
    }

    public DataResult(boolean success, Integer code, String msg, List<T> result) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.result = result;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "DataResult{" +
                "success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataResult<?> result1 = (DataResult<?>) o;

        if (isSuccess() != result1.isSuccess()) return false;
        if (!getCode().equals(result1.getCode())) return false;
        if (!getMsg().equals(result1.getMsg())) return false;
        return getResult().equals(result1.getResult());
    }

    @Override
    public int hashCode() {
        int result1 = (isSuccess() ? 1 : 0);
        result1 = 31 * result1 + getCode().hashCode();
        result1 = 31 * result1 + getMsg().hashCode();
        result1 = 31 * result1 + getResult().hashCode();
        return result1;
    }
}
