package com.carl.framework.core.pay;


/**
 * 基础请求参数
 * @author Carl
 * @date 2017/2/5
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public abstract class AbsRequestParam {
    private String url;
    private String secKey;
    private int connectTimeOut = 5000;
    private int readTimeOut = 30000;
    private int writeTimeout = 30000;

    private boolean sync = true;

    public boolean isSync() {
        return sync;
    }

    public AbsRequestParam setSync(boolean sync) {
        this.sync = sync;
        return this;
    }

    public int getConnectTimeOut() {
        return connectTimeOut;
    }

    public AbsRequestParam setConnectTimeOut(int connectiTimeOut) {
        this.connectTimeOut = connectiTimeOut;
        return this;
    }

    public int getReadTimeOut() {
        return readTimeOut;
    }

    public AbsRequestParam setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
        return this;
    }

    public int getWriteTimeout() {
        return writeTimeout;
    }

    public AbsRequestParam setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public AbsRequestParam setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getSecKey() {
        return secKey;
    }

    public AbsRequestParam setSecKey(String secKey) {
        this.secKey = secKey;
        return this;
    }
}
