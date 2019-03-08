package com.revature.dao;

import java.sql.SQLException;

public interface UserDao {

	boolean verify(String username,String password) throws SQLException;
}
