package com.example.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.example.model.FaultDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * the Fault.
 */
@Schema(description = "the Fault.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-30T16:46:59.619Z[GMT]")


public class Fault   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("severity")
  private String severity = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("sourceSystem")
  private String sourceSystem = null;

  @JsonProperty("faultDetails")
  @Valid
  private List<FaultDetails> faultDetails = null;

  public Fault code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Code represents the fault code composed of three fields separated by  - characters. The first field represents the country code (10 for COMMON, 11 for UK). The second field represents the severity (0 for ERROR, 1 for  CRITICAL, 2 for WARNING, 3 for INFO). The third field represents the error code  1000 description Business Exception    2001 description System Exception (meaning Connection Error) 2002 description System Exception (meaning Read Timeout) 3000 description Validation Exception 
   * @return code
   **/
  @Schema(example = "1000, 2000, 3000", required = true, description = "Code represents the fault code composed of three fields separated by  - characters. The first field represents the country code (10 for COMMON, 11 for UK). The second field represents the severity (0 for ERROR, 1 for  CRITICAL, 2 for WARNING, 3 for INFO). The third field represents the error code  1000 description Business Exception    2001 description System Exception (meaning Connection Error) 2002 description System Exception (meaning Read Timeout) 3000 description Validation Exception ")
      @NotNull

    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Fault severity(String severity) {
    this.severity = severity;
    return this;
  }

  /**
   * Severity of the message info. Error severity will be either CRITICAL, ERROR, WARNING and INFORMATION
   * @return severity
   **/
  @Schema(example = "ERROR", required = true, description = "Severity of the message info. Error severity will be either CRITICAL, ERROR, WARNING and INFORMATION")
      @NotNull

    public String getSeverity() {
    return severity;
  }

  public void setSeverity(String severity) {
    this.severity = severity;
  }

  public Fault description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Technical descriptions associated with errors that assist operation  support team/processes but will NOT be passed back to consumer.  This will be one of the values Business Exception, System Exception or Validation Exception. example: Business Exception 
   * @return description
   **/
  @Schema(description = "Technical descriptions associated with errors that assist operation  support team/processes but will NOT be passed back to consumer.  This will be one of the values Business Exception, System Exception or Validation Exception. example: Business Exception ")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Fault sourceSystem(String sourceSystem) {
    this.sourceSystem = sourceSystem;
    return this;
  }

  /**
   * Source system generating the error. This will be one of the values RestAPI or Backend but will NOT be passed back to consumers. 
   * @return sourceSystem
   **/
  @Schema(example = "RestAPI", description = "Source system generating the error. This will be one of the values RestAPI or Backend but will NOT be passed back to consumers. ")
  
    public String getSourceSystem() {
    return sourceSystem;
  }

  public void setSourceSystem(String sourceSystem) {
    this.sourceSystem = sourceSystem;
  }

  public Fault faultDetails(List<FaultDetails> faultDetails) {
    this.faultDetails = faultDetails;
    return this;
  }

  public Fault addFaultDetailsItem(FaultDetails faultDetailsItem) {
    if (this.faultDetails == null) {
      this.faultDetails = new ArrayList<FaultDetails>();
    }
    this.faultDetails.add(faultDetailsItem);
    return this;
  }

  /**
   * Full details of the message as provided by the source System but will NOT be passed back to consumers.
   * @return faultDetails
   **/
  @Schema(description = "Full details of the message as provided by the source System but will NOT be passed back to consumers.")
      @Valid
  @Size(max=200)   public List<FaultDetails> getFaultDetails() {
    return faultDetails;
  }

  public void setFaultDetails(List<FaultDetails> faultDetails) {
    this.faultDetails = faultDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fault fault = (Fault) o;
    return Objects.equals(this.code, fault.code) &&
        Objects.equals(this.severity, fault.severity) &&
        Objects.equals(this.description, fault.description) &&
        Objects.equals(this.sourceSystem, fault.sourceSystem) &&
        Objects.equals(this.faultDetails, fault.faultDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, severity, description, sourceSystem, faultDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fault {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    sourceSystem: ").append(toIndentedString(sourceSystem)).append("\n");
    sb.append("    faultDetails: ").append(toIndentedString(faultDetails)).append("\n");
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
