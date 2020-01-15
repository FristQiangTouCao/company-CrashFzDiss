package com.yudao.entity;

/**
 * @Description
 * @Author weed
 * @Address 江干区 迈达商业中心
 * @Date 2020/1/15 0015 10:19
 * @Version
 */
public class FzDiss {
    private String content;

    private String phone;

    private String userIcon;

    private String userNick;

    private String userId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FzDiss{" +
                "content='" + content + '\'' +
                ", phone='" + phone + '\'' +
                ", userIcon='" + userIcon + '\'' +
                ", userNick='" + userNick + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
