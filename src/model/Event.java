package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {

	private int id;
	private String title;
	private String description;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private ArrayList<String> userEmails;
	
	public Event() {}
	
	public Event(int id, String title, String description, LocalDateTime startDate, LocalDateTime endDate) {
		
		setId(id);
		setTitle(title);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		
	}
	
	public Event(String title, String description, LocalDateTime startDate, LocalDateTime endDate, ArrayList<String> emails) {
		
		setId(id);
		setTitle(title);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
		setUserEmails(emails);
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
	     return this.title;
	}

	public void setTitle(String title) {  	
		this.title = title;
	}
	
	public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    
    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    
    public ArrayList<String> getUserEmails() {
    	return this.userEmails;
    }
    
    public void setUserEmails(ArrayList<String> emails) {
    	this.userEmails = emails;
    }
}
