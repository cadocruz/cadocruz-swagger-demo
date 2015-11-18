package br.com.cadocruz.rest;

import java.time.LocalDate;

public class ResponseMessages {

	private long id;
	private String message;
	private LocalDate date = LocalDate.now();

	public ResponseMessages(String message, long id) {
		this.message = message;
		this.id = id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseMessages {id=");
		builder.append(id);
		builder.append(", message=");
		builder.append(message);
		builder.append(", date=");
		builder.append(date);
		builder.append("}");
		return builder.toString();
	}
}
