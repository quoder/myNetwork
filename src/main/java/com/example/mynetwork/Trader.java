package com.example.mynetwork;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Trader {

	String $class, tradeId, firstName, lastName;

	public String get$class() {
		return $class;
	}

	public void set$class(String $class) {
		this.$class = $class;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Trader(String $class, String tradeId, String firstName, String lastName) {
		super();
		this.$class = $class;
		this.tradeId = tradeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Trader() {
		
	}
	
	@Override
    public String toString() {
        return "Trader{" +
                "$class=" + $class +
                ", tradeId='" + tradeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
