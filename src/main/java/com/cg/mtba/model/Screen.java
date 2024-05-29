package com.cg.mtba.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="screen")
@Table(name="screen_table")
public class Screen {
	@Id
	private int screenId;
	@Column(name="screen_name",length=15)
	private String screenName;
	@Column(name="rowss",length=10)
	private int rows;
	@Column(name="columnss",length=10)
	private int columns;
	
	@ManyToOne
	@JoinColumn(name="theatre_id")
	private Theatre theatre;
	
	@JsonIgnore
	@OneToMany(mappedBy="screen",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Show> showList;
	
	
	public Screen() {
		super();
	}
	
	public Screen(int screenId, String screenName, int rows, int columns) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.rows = rows;
		this.columns = columns;
	}

	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}


	public List<Show> getShowList() {
		return showList;
	}

	public void setShowList(List<Show> showList) {
		this.showList = showList;
	}
	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", screenName=" + screenName + ", rows=" + rows + ", columns=" + columns
				+ ", theatre=" + theatre + "]";
	}
	

}