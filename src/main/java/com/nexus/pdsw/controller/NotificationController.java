/*------------------------------------------------------------------------------
 * NAME : NotificationController.java
 * DESC : SSE 방식의 실시간 알림
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/02/05  최상원                       초기작성
 * 2025/04/04  최상원                       구독 요청 시 상담원ID 추가
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.nexus.pdsw.dto.request.PostRedisMessagePublishRequestDto;
import com.nexus.pdsw.service.NotificationService;
import com.nexus.pdsw.service.RedisMessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Slf4j
@RequestMapping("notification")
@RequiredArgsConstructor
@RestController
public class NotificationController {

  private final NotificationService notificationService;
  private final RedisMessageService redisMessageService;
  
  /*
   *  실시간 이벤트 구독
   *  
   *  @param String tenantId  테넌트ID
   *  @param String counselorId  상담원ID
   *  @return ResponseEntity<SseEmitter>
   */
  @GetMapping(value = "/{tenantId}/subscribe/{counselorId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public ResponseEntity<SseEmitter> subscribe(
    @PathVariable("tenantId") String tenantId,
    @PathVariable("counselorId") String counselorId,
    @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "") String lastEventId
  ) {
    return ResponseEntity.ok(notificationService.subscribe(tenantId, counselorId));
  }

  /*
   *  실시간 이벤트 발행 수정 필요할 듯
   *  
   *  @param PostRedisMessagePublishRequestDto requestBody  발행 메시지 전달 개체 DTO
   *  @return void
   */
  @PostMapping("/publish")
  public void publish(
    @RequestBody PostRedisMessagePublishRequestDto requestBody
  ) {
    redisMessageService.publicNotification(requestBody);
  }
}
