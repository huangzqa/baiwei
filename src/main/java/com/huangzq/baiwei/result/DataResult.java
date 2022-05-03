package com.huangzq.baiwei.result;

import java.util.List;

public class DataResult<T> {
    private boolean success;
    private String msg;
    private List<T> result;

    public DataResult() {
    }

    public DataResult(boolean success, String msg, List<T> result) {
        this.success = success;
        this.msg = msg;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DataResult<?> that = (DataResult<?>) o;

        if (isSuccess() != that.isSuccess()) {
            return false;
        }
        if (!getMsg().equals(that.getMsg())) {
            return false;
        }
        return getResult().equals(that.getResult());
    }

    @Override
    public int hashCode() {
        int result1 = (isSuccess() ? 1 : 0);
        result1 = 31 * result1 + getMsg().hashCode();
        result1 = 31 * result1 + getResult().hashCode();
        return result1;
    }

    @Override
    public String toString() {
        return "DataResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
