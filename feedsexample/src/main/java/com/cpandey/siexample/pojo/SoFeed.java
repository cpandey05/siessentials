package com.cpandey.siexample.pojo;

import java.util.List;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
/**
 * Mapping from SyndEntry to Internal Domain class 
 *
 * @author Chandan Pandey
 *
 */
public class SoFeed {
	private String title;
	private String description;
	private String link;
	private String author;
	
	private List<SyndCategoryImpl> categories;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<SyndCategoryImpl> getCategories() {
		return categories;
	}
	public void setCategories(List<SyndCategoryImpl> categories) {
		this.categories = categories;
	}
	@Override
	public String toString() {
		StringBuffer str=new StringBuffer();
		str.append(title==null?"":title);
		str.append(description==null?"":description);
		str.append(link==null?"":link);
		str.append(author==null?"":author);
		if(categories!=null&&categories.size()>0){
			for (SyndCategoryImpl category: categories) {
				str.append(category.getName());
				
			}
		}
		return str.toString();
	}	
}
