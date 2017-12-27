package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CUSTOMERID database table.
 * 
 */
@Entity
@Table(name="CUSTOMERID")
@NamedQuery(name="Customerid.findAll", query="SELECT c FROM Customerid c")
public class Customerid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUSTOMERID_CUSTOMERID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMERID_CUSTOMERID_GENERATOR")
	@Column(unique=true, nullable=false, precision=22)
	private long customerid;

	@Column(name="DRV_LIC_NO", nullable=false, precision=22)
	private BigDecimal drvLicNo;

	public Customerid() {
	}

	public long getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public BigDecimal getDrvLicNo() {
		return this.drvLicNo;
	}

	public void setDrvLicNo(BigDecimal drvLicNo) {
		this.drvLicNo = drvLicNo;
	}

}