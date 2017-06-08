package com.example.mynetwork;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Commodity {

    String $class, tradingSymbol, description, mainExchange, quantity, owner;

	
	public String get$class() {
		return $class;
	}

	public void set$class(String $class) {
		this.$class = $class;
	}

	public String getTradingSymbol() {
		return tradingSymbol;
	}

	public void setTradingSymbol(String tradingSymbol) {
		this.tradingSymbol = tradingSymbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMainExchange() {
		return mainExchange;
	}

	public void setMainExchange(String mainExchange) {
		this.mainExchange = mainExchange;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Commodity() {
		
	}
	
	
	
	public Commodity(String $class, String tradingSymbol, String description, String mainExchange, String quantity,
			String owner) {
		super();
		this.$class = $class;
		this.tradingSymbol = tradingSymbol;
		this.description = description;
		this.mainExchange = mainExchange;
		this.quantity = quantity;
		this.owner = owner;
	}
	@Override
    public String toString() {
        return "Commodity{" +
                "$class=" + $class +
                ", tradingSymbol='" + tradingSymbol+ '\'' +
                ", description='" + description + '\'' +
                ", mainExchange='" + mainExchange + '\'' +
                ", quantity='" + quantity + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
