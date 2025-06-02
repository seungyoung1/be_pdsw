/*------------------------------------------------------------------------------
 * NAME : ResponseMessage.java
 * DESC : 반환 메시지 정의
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/01/15  최상원                       초기작성
 * 2025/02/14  최상원                       NOT_EXISTED_DIALER 추가가
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.common;

public interface ResponseMessage {
  
  // HTTP Status 200
  String SUCCESS = "Success";

  // HTTP Status 400(Bad Request)
  String VALIDATION_FAILED = "Validation failed.";
  String NOT_EXISTED_DIALER = "다이얼 장비가 존재하지 않습니다.";
  String NOT_EXISTED_ROLE = "역할이 존재하지 않습니다.";
  String NOT_EXISTED_MENU = "메뉴가 존재하지 않습니다.";
  String NOT_EXISTED_SESSIONKEY = "API 인증 세션키가 존재하지 않습니다.";
  String NOT_EXISTED_CENTERID = "센터ID가 존재하지 않습니다.";
  String NOT_EXISTED_TENANTID = "테넌트ID가 존재하지 않습니다.";
  String NOT_EXISTED_CAMPAIGNID = "캠페인ID가 존재하지 않습니다.";
  String NOT_EXISTED_SKILLID = "스킬ID가 존재하지 않습니다.";
  String NOT_EXISTED_REDISHASH = "레디스 Hash 테이브이 존재하지 않습니다.";

  // HTTP Status 401(Unauthorized)

  // HTTP Status 403(Forbidden)
  String NOT_MATCHED_PASSWORD = "Miss Matched Your Password.";
  String EXCEEDING_3TIMES = "The number of password failures exceeded 3 times. Please contact your administrator to log in.";

  // HTTP Status 500(Internal Server Error)
  String DATABASE_ERROR = "Database error.";
}
