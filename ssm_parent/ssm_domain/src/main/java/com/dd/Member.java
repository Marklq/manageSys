package com.dd;

/**
 * 会员类
 */
public class Member {
    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;


    public String getId() {

        if (1==1){
            System.out.println("0000000000000000000000000");
        }

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}