package com.yusw.northstar.biz.result;

import java.io.Serializable;

/**
 * Created by yusw on 2016/12/13.
 */
public class NorthstarResult<T> implements Serializable{
    private static final long serialVersionUID = 3517131284241742527L;
    public boolean isSuccess = true;
    public T data;
}
