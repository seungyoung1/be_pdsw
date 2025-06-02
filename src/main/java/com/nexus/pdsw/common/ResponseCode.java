/*------------------------------------------------------------------------------
 * NAME : ResponseCode.java
 * DESC : 반환 코드 정의
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/01/15  최상원                       초기작성
 * 2025/02/14  최상원                       NOT_EXISTED_DIALER 다이얼 장비가 존재하지 않습니다.
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.common;

public interface ResponseCode {
  
  // HTTP Status 200
  String SUCCESS = "SU";

  // HTTP Status 400(Bad Request)
  String VALIDATION_FAILED = "VF";
  String NOT_EXISTED_DIALER = "NED";                  //다이얼 장비가 존재하지 않습니다.
  String NOT_EXISTED_ROLE = "NR";                     //존재하지 않는 역할
  String NOT_EXISTED_MENU = "NM";                     //존재하지 않는 메뉴
  String NOT_EXISTED_SESSIONKEY = "NES";              //API 인증 세션키가 존재하지 않습니다.
  String NOT_EXISTED_CENTERID = "NECT";               //센터ID가 존재하지 않습니다.
  String NOT_EXISTED_TENANTID = "NET";                //테넌트ID가 존재하지 않습니다.
  String NOT_EXISTED_CAMPAIGNID = "NEC";              //캠페인ID가 존재하지 않습니다.
  String NOT_EXISTED_SKILLID = "NEK";                 //스킬ID가 존재하지 않습니다.
  String NOT_EXISTED_REDISHASH = "NER";               //레디스 Hash 테이브이 존재하지 않습니다.
  // HTTP Status 401(Unauthorized)

  // HTTP Status 403(Forbidden)
  String NOT_MATCHED_PASSWORD = "NMP";                //비밀번호가 일지하지 않을때
  String EXCEEDING_3TIMES = "E3T";                    //비밀번호 실패 3회초과

  // HTTP Status 500(Internal Server Error)
  String DATABASE_ERROR = "DBE";
}
