/*------------------------------------------------------------------------------
 * NAME : EventLogServiceImpl.java
 * DESC : 이벤트 로그 저장 구현체
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
package com.nexus.pdsw.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nexus.pdsw.dto.request.PostEventLogRequestDto;
import com.nexus.pdsw.dto.response.ResponseDto;
import com.nexus.pdsw.dto.response.eventLog.PostEventLogResponseDto;
import com.nexus.pdsw.entity.EventLogEntity;
import com.nexus.pdsw.repository.EventLogRepository;
import com.nexus.pdsw.service.EventLogService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventLogServiceImpl implements EventLogService {

  private final EventLogRepository eventLogRepository;
  
  /*  
   *  이벤트 로그 저장하기
   *  
   *  @param PostEventLogRequestDto requestBody  이벤트 로그 전달 DTO
   *  @param String clientIp                     클라이언트IP
   *  @return ResponseEntity<? super PostEventLogResponseDto>
   */
  @Override
  public ResponseEntity<? super PostEventLogResponseDto> saveEventLog(PostEventLogRequestDto dto, String clientIp) {

    try {
      
      EventLogEntity rsEventLog = new EventLogEntity(dto, clientIp);
      // log.info(">>>이벤트명: {}, 상담사ID: {}", dto.getEventName().toString(), dto.getEmployeeId().toString());
      eventLogRepository.save(rsEventLog);
      
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseDto.databaseError();
    }

    return PostEventLogResponseDto.success();
  }
  
}
