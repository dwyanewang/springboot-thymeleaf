package com.dwyanewang.entity;


public class TLoggerInfos {

  private long aliId;
  private String aliClientIp;
  private String aliUri;
  private String aliType;
  private String aliMethod;
  private String aliParamData;
  private String aliSessionId;
  private java.sql.Timestamp aliTime;
  private String aliReturmTime;
  private String aliReturnData;
  private String aliHttpStatusCode;
  private long aliTimeConsuming;


  public long getAliId() {
    return aliId;
  }

  public void setAliId(long aliId) {
    this.aliId = aliId;
  }


  public String getAliClientIp() {
    return aliClientIp;
  }

  public void setAliClientIp(String aliClientIp) {
    this.aliClientIp = aliClientIp;
  }


  public String getAliUri() {
    return aliUri;
  }

  public void setAliUri(String aliUri) {
    this.aliUri = aliUri;
  }


  public String getAliType() {
    return aliType;
  }

  public void setAliType(String aliType) {
    this.aliType = aliType;
  }


  public String getAliMethod() {
    return aliMethod;
  }

  public void setAliMethod(String aliMethod) {
    this.aliMethod = aliMethod;
  }


  public String getAliParamData() {
    return aliParamData;
  }

  public void setAliParamData(String aliParamData) {
    this.aliParamData = aliParamData;
  }


  public String getAliSessionId() {
    return aliSessionId;
  }

  public void setAliSessionId(String aliSessionId) {
    this.aliSessionId = aliSessionId;
  }


  public java.sql.Timestamp getAliTime() {
    return aliTime;
  }

  public void setAliTime(java.sql.Timestamp aliTime) {
    this.aliTime = aliTime;
  }


  public String getAliReturmTime() {
    return aliReturmTime;
  }

  public void setAliReturmTime(String aliReturmTime) {
    this.aliReturmTime = aliReturmTime;
  }


  public String getAliReturnData() {
    return aliReturnData;
  }

  public void setAliReturnData(String aliReturnData) {
    this.aliReturnData = aliReturnData;
  }


  public String getAliHttpStatusCode() {
    return aliHttpStatusCode;
  }

  public void setAliHttpStatusCode(String aliHttpStatusCode) {
    this.aliHttpStatusCode = aliHttpStatusCode;
  }


  public long getAliTimeConsuming() {
    return aliTimeConsuming;
  }

  public void setAliTimeConsuming(long aliTimeConsuming) {
    this.aliTimeConsuming = aliTimeConsuming;
  }

  @Override
  public String toString() {
    return "TLoggerInfos{" +
            "aliId=" + aliId +
            ", aliClientIp='" + aliClientIp + '\'' +
            ", aliUri='" + aliUri + '\'' +
            ", aliType='" + aliType + '\'' +
            ", aliMethod='" + aliMethod + '\'' +
            ", aliParamData='" + aliParamData + '\'' +
            ", aliSessionId='" + aliSessionId + '\'' +
            ", aliTime=" + aliTime +
            ", aliReturmTime='" + aliReturmTime + '\'' +
            ", aliReturnData='" + aliReturnData + '\'' +
            ", aliHttpStatusCode='" + aliHttpStatusCode + '\'' +
            ", aliTimeConsuming=" + aliTimeConsuming +
            '}';
  }
}
