/**
 * 
 */
package com.cogent.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author: Joi
 * @date: Feb 9, 2023
 */

@Entity
@Table(name="authors")
public class Author {
	@Id
	private Integer authorId;
	private String authorName;
	private String authorAddress;
	private long authorPhone;
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(Integer authorId, String authorName, String authorAddress, long authorPhone) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorAddress = authorAddress;
		this.authorPhone = authorPhone;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorAddress() {
		return authorAddress;
	}

	public void setAuthorAddress(String authorAddress) {
		this.authorAddress = authorAddress;
	}

	public long getAuthorPhone() {
		return authorPhone;
	}

	public void setAuthorPhone(long authorPhone) {
		this.authorPhone = authorPhone;
	}
}
