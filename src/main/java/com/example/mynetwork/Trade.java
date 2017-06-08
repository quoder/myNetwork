package com.example.mynetwork;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Trade {
	String $class, transactionId, commodity, newOwner, timestamp;
	public String get$class() {
		return $class;
	}

	public void set$class(String $class) {
		this.$class = $class;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getNewOwner() {
		return newOwner;
	}

	public void setNewOwner(String newOwner) {
		this.newOwner = newOwner;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Trade(String $class, String commodity, String newOwner) {
		super();
		this.$class = $class;
		this.commodity = commodity;
		this.newOwner = newOwner;
	}
	
	public Trade() {
		
	}

	@Override
    public String toString() {
        return "Trade{" +
                "$class=" + $class +
                ", transactionId='" + transactionId + '\'' +
                ", commodity='" + commodity + '\'' +
                ", newOwner='" + newOwner + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

}
