package com.jga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BaseDao {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://cs5200-spring2018-su.c8ag9kxpvwof.us-east-2.rds.amazonaws.com/hw2_Su_Zhongnan_spring_2018";
	final String USER = "zhongnan";
	final String PASS = "szn_13894831135";
    Connection conn = null;
    PreparedStatement pstmt = null;
    

}
