package com.example.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * the FaultDetails.
 */
@Schema(description = "the FaultDetails.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-30T16:46:59.619Z[GMT]")


public class FaultDetails   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("context")
  private String context = null;

  public FaultDetails name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the detail provided to supplement the error.
   * @return name
   **/
  @Schema(required = true, description = "Name of the detail provided to supplement the error.")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FaultDetails value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Value of the detail provided to supplement the error.
   * @return value
   **/
  @Schema(required = true, description = "Value of the detail provided to supplement the error.")
      @NotNull

    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public FaultDetails context(String context) {
    this.context = context;
    return this;
  }

  /**
   * If the faultDetails is applicable for a particular instance of a request payload, context information can be provided here.
   * @return context
   **/
  @Schema(example = "Oracle DB", required = true, description = "If the faultDetails is applicable for a particular instance of a request payload, context information can be provided here.")
      @NotNull

    public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FaultDetails faultDetails = (FaultDetails) o;
    return Objects.equals(this.name, faultDetails.name) &&
        Objects.equals(this.value, faultDetails.value) &&
        Objects.equals(this.context, faultDetails.context);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, context);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FaultDetails {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
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
