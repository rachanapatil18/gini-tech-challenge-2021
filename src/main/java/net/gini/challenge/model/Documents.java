/**
 * 
 */
package net.gini.challenge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rachana
 *
 */
@Entity
@Table(name = "DOCUMENTS")
public class Documents implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String type;
	private String serial_number;
	private Long pages;
	//private String environment;

	public Documents() {
	}

	public Documents(Long id, String type, String serial_number, Long pages) {
		super();
		this.id = id;
		this.type = type;
		this.serial_number = serial_number;
		this.pages = pages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public Long getPages() {
		return pages;
	}

	public void setPages(Long pages) {
		this.pages = pages;
	}


	@Override
	public String toString() {
		return "Documents [id=" + id + ", type=" + type + ", serial_number=" + serial_number + ", pages=" + pages + "]";
	}

}
