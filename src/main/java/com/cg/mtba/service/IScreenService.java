package com.cg.mtba.service;

import java.util.List;

import com.cg.mtba.exception.ScreenException;
import com.cg.mtba.model.Screen;

public interface IScreenService {
	
	public Screen addScreen(Screen screen) throws ScreenException;
	
	public Screen deleteScreen(int screenId) throws ScreenException;
	
	public Screen updateScreen(Screen screen) throws ScreenException;
	
	public List<Screen> viewScreenList() throws ScreenException;

	Screen viewScreen(int screenid) throws ScreenException;
}