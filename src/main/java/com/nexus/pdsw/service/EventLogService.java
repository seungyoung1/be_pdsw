/*------------------------------------------------------------------------------
 * NAME : EventLogService.java
 * DESC : 이벤트 로그 기록
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/02/05  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.service;

import org.springframework.http.ResponseEntity;

import com.nexus.pdsw.dto.request.PostEventLogRequestDto;
import com.nexus.pdsw.dto.response.eventLog.PostEventLogResponseDto;

public interface EventLogService {
  
  /*  
   *  이벤트 로그 저장하기
   *  
   *  @param PostEventLogRequestDto requestBody  이벤트 로그 전달 DTO
   *  @param String clientIp                     클라이언트IP
   *  @return ResponseEntity<? super PostEventLogResponseDto>
   */
  ResponseEntity<? super PostEventLogResponseDto> saveEventLog(PostEventLogRequestDto requestBody, String clientIp);

}
