package com.dwyanewang.dao;

import com.dwyanewang.entity.TLoggerInfos;
import com.dwyanewang.entity.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;

public class UserSqlProvider {
    public String listByUsername(String username) {
        return "select * from t_user where USERNAME = #{username}";
    }

    public String getBadUser(String username, String password) {
        return new SQL() {{
            SELECT("*");
            FROM("t_user");
            if (username != null && password != null) {
                WHERE("USERNAME like '%" + username + "%'   and PASSWORD like '%" + password + "%'");
            } else {
                WHERE("1=2");
            }
        }}.toString();
    }

    /**
     * 1.用于获取结果集的映射关系
     */
    private static String getResultsStr(Class aClass) {
        StringBuilder sb = new StringBuilder();
        sb.append("@Results({\n");
        for (Field field : aClass.getDeclaredFields()) {
            String fieldName = field.getName();
            //映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = new PropertyNamingStrategy.SnakeCaseStrategy().translate(fieldName).toUpperCase();
            sb.append(String.format("@Result(property = \"%s\",column = \"%s\"),\n", fieldName, column));
        }
        sb.append("})");
        return sb.toString();
    }

    /**
     * 2.打印结果集的映射关系. 例如：
     *
     * @Results({
     * @Result(property = "userId", column = "USER_ID"),
     * @Result(property = "username", column = "USERNAME"),
     * @Result(property = "password", column = "PASSWORD"),
     * @Result(property = "mobileNum", column = "PHONE_NUM"),
     * })
     */
    public static void main(String[] args) {
//        System.out.println(getResultsStr(TLoggerInfos.class));
        System.out.println(getResultsStr(User.class));

    }
}
