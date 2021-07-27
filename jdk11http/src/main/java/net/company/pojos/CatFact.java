package net.company.pojos;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A pojo that represents a cat fact.
 * @author dmitrilc
 *
 */
public class CatFact {
	private String fact;
	private int length;
	
	/**
	 * The constructor is required by Jackson.
	 * <p>
	 * {@link JsonProperty} annotations are required on fields for Jackson.
	 * @param fact
	 * @param length
	 */
	public CatFact(
		@JsonProperty("fact")String fact, 
		@JsonProperty("length")int length) {
		this.fact = fact;
		this.length = length;
	}

	public String getFact() {
		return fact;
	}

	public int getLength() {
		return length;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fact, length);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatFact other = (CatFact) obj;
		return Objects.equals(fact, other.fact) && length == other.length;
	}

	@Override
	public String toString() {
		return "CatFact [fact=" + fact + ", length=" + length + "]";
	}

}
