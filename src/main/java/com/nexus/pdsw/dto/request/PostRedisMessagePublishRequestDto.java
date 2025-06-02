/*------------------------------------------------------------------------------
 * NAME : PostRedisMessagePublishRequestDto.java
 * DESC : 실시간 이벤트 발행 요청 시 전달 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/02/17  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.request;

import com.nexus.pdsw.dto.object.NotificationDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostRedisMessagePublishRequestDto {
  
  private String tenantId;
  private NotificationDto notification;
}
