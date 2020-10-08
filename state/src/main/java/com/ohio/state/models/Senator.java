package com.ohio.state.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "senator")
public class Senator implements Serializable {
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "vote")
	private String vote;
	protected Senator() {
		
	}
	public Senator(String firstName, String lastName, String vote) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.vote = vote;
	}
	@Override
	public String toString() {
		return String.format("Senator[id=%d, firstName='%s', lastName='%s', voted='%s']", id, firstName, lastName, vote);
	}
}
