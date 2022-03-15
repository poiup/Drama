package kr.co.drama.servlet.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IDramaService {
	void execute(HttpServletRequest request, HttpServletResponse response) throws SQLException;

}
