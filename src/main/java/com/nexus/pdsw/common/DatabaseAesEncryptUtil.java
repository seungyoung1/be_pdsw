/*------------------------------------------------------------------------------
 * NAME : DatabaseAesEncryptUtil.java
 * DESC : AES_ENCRYPT를 통한 데이터 암/복호화
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

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class DatabaseAesEncryptUtil {
  
  //암호화
  public static String encryption(String text, String dbKey) {

    try {
      Cipher cipher = Cipher.getInstance("AES");
      byte[] key = new byte[16];
      int i = 0;
      for(byte b : dbKey.getBytes()) {
        key[i++%16] ^= b;
      }
      cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
      return new String(Hex.encodeHex(cipher.doFinal(text.getBytes("UTF-8")))).toUpperCase();
    } catch(Exception e) {
      return text;
    }
  }

  // 복호화
  public static String decryption(String encryptedText, String dbKey) {
    try {
      Cipher cipher = Cipher.getInstance("AES");
      byte[] key = new byte[16];
      int i = 0;
      for(byte b : dbKey.getBytes()) {
        key[i++%16] ^= b;
      }
      cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
      return new String(cipher.doFinal(Hex.decodeHex(encryptedText.toCharArray())));
    } catch(Exception e) {
      return encryptedText;
    }
  }
}
