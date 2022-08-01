package com.example.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The Request object of Provision notification.
 */
@Schema(description = "The Request object of CreditCard.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-30T16:46:59.619Z[GMT]")
@Entity
@Table
public class CreditCard implements Serializable   {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="ID")
  private Long id;
	
  @JsonProperty("fullName")
  @Column(name="FULL_NAME")
  private String fullName = null;

  @JsonProperty("cardNumber")
  @Column(name="CARD_NUMBER", unique = true, nullable = false)
  private String cardNumber = null;

  @JsonProperty("limit")
  @Column(name="LIMITS")
  private Long limit = null;

  @JsonProperty("balance")
  @Column(name="BALANCE")
  private Long balance = null;

  @JsonProperty("currency")
  @Column(name="CURRENCY")
  private String currency = null;

  public CreditCard fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Given name of the card holder. 
   * @return fullName
   **/
  @Schema(example = "John Smith", required = true, description = "Given name of the card holder. ")
      @NotNull

  @Pattern(regexp="^[a-zA-Z0-9 ]*") @Size(min=2,max=50)   public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public CreditCard cardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  /**
   * card number for the credit card payment system 
   * @return cardNumber
   **/
  @Schema(example = "5545880003605994", required = true, description = "card number for the credit card payment system ")
      @NotNull

    public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public CreditCard limit(Long limit) {
    this.limit = limit;
    return this;
  }

  /**
   * credit limit for the consumers. 
   * @return limit
   **/
  @Schema(example = "2000", required = true, description = "credit limit for the consumers. ")
      @NotNull

    public Long getLimit() {
    return limit;
  }

  public void setLimit(Long limit) {
    this.limit = limit;
  }

  public CreditCard balance(Long balance) {
    this.balance = balance;
    return this;
  }

  /**
   * actual amount that the consumer holding and could be utilzed for any purchase. 
   * @return balance
   **/
  @Schema(description = "actual amount that the consumer holding and could be utilzed for any purchase. ")
  
    public Long getBalance() {
    return balance;
  }

  public void setBalance(Long balance) {
    this.balance = balance;
  }

  public CreditCard currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Currency 
   * @return currency
   **/
  @Schema(example = "£", description = "Currency ")
  
  @Pattern(regexp="^[a-zA-Z0-9\\s\\-\\':!#$%&'*+\\-./=?^_`{|}~]{1,255}$")   public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditCard creditCard = (CreditCard) o;
    return Objects.equals(this.id, creditCard.id) &&
    	Objects.equals(this.fullName, creditCard.fullName) &&
        Objects.equals(this.cardNumber, creditCard.cardNumber) &&
        Objects.equals(this.limit, creditCard.limit) &&
        Objects.equals(this.balance, creditCard.balance) &&
        Objects.equals(this.currency, creditCard.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullName, cardNumber, limit, balance, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCard {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
