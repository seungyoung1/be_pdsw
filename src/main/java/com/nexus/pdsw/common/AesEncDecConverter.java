/*------------------------------------------------------------------------------
 * NAME : AesEncDecConverter.java
 * DESC : DB 항목 암호화
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/02/04  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.common;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AesEncDecConverter implements AttributeConverter<String, String> {
  
	private static String dbKey = "nexus6@$)2%*)";

  @Override
  public String convertToDatabaseColumn(String data) {
    return (data != null) ? DatabaseAesEncryptUtil.encryption(data, dbKey) : "";
  }

  @Override
  public String convertToEntityAttribute(String data) {
    return (data != null) ? DatabaseAesEncryptUtil.decryption(data, dbKey) : "";
  }

}
