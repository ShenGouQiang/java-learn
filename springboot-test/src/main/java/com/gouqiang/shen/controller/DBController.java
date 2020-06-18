package com.gouqiang.shen.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
public class DBController {

    @RequestMapping("/compare/intandbigint")
    public String compareIntAndBigInt() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://www.shengouqiang.cn:3306/bigger_shen?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT",
                "BiggerShen",
                "dandan19960813");
        PreparedStatement  statement1 = connection.prepareStatement("INSERT INTO PSN(id,name) value (?,?)");
        PreparedStatement  statement2 = connection.prepareStatement("INSERT INTO PSN2(id,name) value (?,?)");
        for (int i=11000;i<20000;i++){
            statement1.setInt(1,i);
            statement1.setString(2,i+"");
            statement1.addBatch();
            statement2.setInt(1,i);
            statement2.setString(2,i+"");
            statement2.addBatch();
        }
        statement1.executeBatch();
        statement2.executeBatch();
        connection.close();
        JSONObject obj = new JSONObject();
        obj.put("code",0);
        return obj.toJSONString();
    }
}
