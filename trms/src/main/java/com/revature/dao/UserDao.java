package com.revature.dao;

import java.sql.SQLException;

public interface UserDao {

	Integer verify(String username,String password) throws SQLException;
}
