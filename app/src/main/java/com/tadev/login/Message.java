package com.tadev.login;

/**
 * Created by PC on 10/05/2016.
 */
public class Message {
    private String msgErrorUser;
    private String msgLoginFailed;
    private String msgErrorPwd;

    private String msgEmpty;


    public String getMsgErrorUser() {
        return msgErrorUser;
    }

    public void setMsgErrorUser(String msgErrorUser) {
        this.msgErrorUser = msgErrorUser;
    }

    public String getMsgLoginFailed() {
        return msgLoginFailed;
    }

    public void setMsgLoginFailed(String msgLoginFailed) {
        this.msgLoginFailed = msgLoginFailed;
    }

    public String getMsgErrorPwd() {
        return msgErrorPwd;
    }

    public void setMsgErrorPwd(String msgErrorPwd) {
        this.msgErrorPwd = msgErrorPwd;
    }


    public String getMsgEmpty() {
        return msgEmpty;
    }

    public void setMsgEmpty(String msgEmpty) {
        this.msgEmpty = msgEmpty;
    }
}
