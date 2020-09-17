package com.creolophus.liuyi.common.json;

/**
 * @author magicnana
 * @date 2020/9/17 10:09 AM
 */
public class User {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"").append(name).append('\"');
        sb.append(",\"password\":\"").append(password).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
