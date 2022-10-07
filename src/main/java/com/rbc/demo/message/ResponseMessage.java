package com.rbc.demo.message;

import java.util.Objects;

public class ResponseMessage {
	/**
	 * Response message.
	 */
	private String message;

	public ResponseMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseMessage other = (ResponseMessage) obj;
		return Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + "]";
	}
}
