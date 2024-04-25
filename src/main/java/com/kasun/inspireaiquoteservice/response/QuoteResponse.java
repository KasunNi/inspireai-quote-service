package com.kasun.inspireaiquoteservice.response;

import java.util.List;

public class QuoteResponse {

	private int id;
	private String title;
	private String quote;
	private String tags;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    
 // Utility method to get tags as an array
    public String[] getTagsArray() {
        return tags != null ? tags.split(",") : new String[0];
    }

    // Utility method to set tags from an array
    public void setTagsFromArray(String[] tagsArray) {
        this.tags = tagsArray != null ? String.join(",", tagsArray) : null;
    }
	
}
