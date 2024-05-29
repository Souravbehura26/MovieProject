package com.cg.mtba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtba.dao.IScreenRepository;
import com.cg.mtba.exception.BookingException;
import com.cg.mtba.exception.ScreenException;
import com.cg.mtba.model.Screen;
import com.cg.mtba.model.TicketBooking;

@Service
public class ScreenServiceImpn implements IScreenService {

	@Autowired
	public IScreenRepository screenrepo;

	@Override
	public Screen addScreen(Screen screen) throws ScreenException {
		if (!screenrepo.existsById(screen.getScreenId())) {
			screenrepo.save(screen);
			return screen;
		}
		return null;
	}

	@Override
	public Screen deleteScreen(int screenId) throws ScreenException{
		if (screenrepo.existsById(screenId)) {
			Screen screen = screenrepo.findById(screenId).get();
			screenrepo.deleteById(screenId);
			return screen;
		}
		return null;
	}

	@Override
	public Screen updateScreen(Screen screen) throws ScreenException {

		if (screenrepo.existsById(screen.getScreenId())) {
			screenrepo.save(screen);
			return screen;
		}
		return null;
	}

	@Override
	public List<Screen> viewScreenList() throws ScreenException {
		List<Screen> screenList = screenrepo.findAll();
		if (screenList.size() > 0) {
			return screenList;
		}
		return null;
	}
	
	@Override
	public Screen viewScreen(int screenid) throws ScreenException {
		if (screenrepo.existsById(screenid)) {
			Optional<Screen> sc=screenrepo.findById(screenid);
			Screen s=sc.get();
			return s;
		}
		return null;
	}

}