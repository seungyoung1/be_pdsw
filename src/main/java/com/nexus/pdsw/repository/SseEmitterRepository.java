/*------------------------------------------------------------------------------
 * NAME : SseEmitterRepository.java
 * DESC : SseEmitter 메모리 기능
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
package com.nexus.pdsw.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Repository
public class SseEmitterRepository {
  
  private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

  public SseEmitter save(String eventId, SseEmitter sseEmitter) {
    emitters.put(eventId, sseEmitter);
    return sseEmitter;
  }

  public Optional<SseEmitter> findById(String eventId) {
    return Optional.ofNullable(emitters.get(eventId));
  }

  public Map<String, SseEmitter> findAll() {
    return emitters;
  }

  public void deleteById(String eventId) {
    emitters.remove(eventId);
  }

  public int getEmitterSize() {
    return emitters.size();
  }

  public boolean containKey(String eventId) {
    return emitters.containsKey(eventId);
  }
}
