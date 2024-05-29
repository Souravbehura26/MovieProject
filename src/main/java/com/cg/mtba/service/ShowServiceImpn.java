package com.cg.mtba.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.mtba.dao.IShowRepository;
import com.cg.mtba.exception.ShowException;
import com.cg.mtba.model.Show;

@Service
public class ShowServiceImpn implements IShowService {

	@Autowired
	private IShowRepository showrepo;

	@Override
	public Show addShow(Show show) throws ShowException {
		if (!showrepo.existsById(show.getShowId())) {
			showrepo.save(show);
			return show;
		}
		return null;
	}

	public Show updateShow(Show show) throws ShowException{

		if (showrepo.existsById(show.getShowId())) {
			showrepo.save(show);
			return show;
		}
		return null;
	}

	public Show removeShow(int showId) throws ShowException{
		if (showrepo.existsById(showId)) {
			Show s=showrepo.findById(showId).get();
			showrepo.delete(s);
			return s;
		}
		return null;
	}

	public Show viewShowById(int showId) throws ShowException {
		if(showrepo.existsById(showId)) {
			Show s=showrepo.getById(showId);
			return s;
		}

		return null;
	}

	public List<Show> viewShowList(int theatreid) throws ShowException{
		List<Show> showList=showrepo.viewShowList(theatreid);
		if(showList.size()>0) {
			return showList;
		}
		return null;
	}

	public Show viewShow(int movieid) throws ShowException {
		Show s=showrepo.viewShow(movieid);
		if(s!=null) {
			return s;
		}
		return null;
	}

	public List<Show> viewAllShows() throws ShowException {
		List<Show> showList = showrepo.findAll();
		if (showList.size() > 0) {
			return showList;
		}
		return null;
	}

}