package com.callor.todo.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TodoCommand {
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
