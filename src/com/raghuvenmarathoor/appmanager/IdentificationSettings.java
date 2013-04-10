/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghuvenmarathoor.appmanager;

import java.io.Serializable;

/**
 *
 * @author New User
 */
public class IdentificationSettings implements Serializable {
    String codegenpath = "";
    boolean useIdentification = false;
    String userName = "";
    String password = "";

    public String getCodegenpath() {
        return codegenpath;
    }

    public void setCodegenpath(String codegenpath) {
        this.codegenpath = codegenpath;
    }

    public boolean isUseIdentification() {
        return useIdentification;
    }

    public void setUseIdentification(boolean useIdentification) {
        this.useIdentification = useIdentification;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
