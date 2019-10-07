package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the hibernate_sequences database table.
 * 
 */
@Entity
@Table(name="hibernate_sequences")
@NamedQuery(name="HibernateSequence.findAll", query="SELECT h FROM HibernateSequence h")
public class HibernateSequence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sequence_name")
	private String sequenceName;

	@Column(name="next_val")
	private BigInteger nextVal;

	public HibernateSequence() {
	}

	public String getSequenceName() {
		return this.sequenceName;
	}

	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}

	public BigInteger getNextVal() {
		return this.nextVal;
	}

	public void setNextVal(BigInteger nextVal) {
		this.nextVal = nextVal;
	}

}