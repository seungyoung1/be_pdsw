/*------------------------------------------------------------------------------
 * NAME : SseEmitterService.java
 * DESC : SseEmitter 관련 기능
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
package com.nexus.pdsw.service;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.nexus.pdsw.dto.object.NotificationDto;

public interface SseEmitterService {
  
  /*
   *  SSE Emitter 생성
   *  
   *  @param String emitterKey   Emitter 키
   *  @return SseEmitter
   */
  public SseEmitter createEmitter(String emitterKey);

  /*
   *  SSE Emitter 삭제
   *  
   *  @param String emitterKey   Emitter 키
   *  @return void
   */
  public void deleteEmitter(String emitterKey);

  /*
   *  클라이언트로 알림 메시지 전송
   *  
   *  @param String emitterKey   Emitter 키
   *  @param NotificationDto notificationDto   알림 DTO객체
   *  @return void
   */
  public void sendNotificationToClient(String emitterKey, NotificationDto notificationDto);

  /*
   *  알림 메시지 전송
   *  
   *  @param Object data            Emitter 키
   *  @param String emitterKey      Emitter 키
   *  @param SseEmitter sseEmitter  SSE Emitter 개체
   *  @return void
   */
  public void send(Object data, String emitterKey, SseEmitter sseEmitter);
}
