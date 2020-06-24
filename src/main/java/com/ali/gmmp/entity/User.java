package com.ali.gmmp.entity;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: ASUS
 * @description: TODO
 * @Date: 22:49 2020/6/24
 */
@Data
@ToString
public class User {
    private String peoNum;
    private String peoIdCard;
    private String peoTel;
    private String peoEmail;
    private String peoDates;

    public User(String peoNum, String peoIdCard) {
        this.peoNum = peoNum;
        this.peoIdCard = peoIdCard;
    }
}
