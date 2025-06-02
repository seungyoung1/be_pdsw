/*------------------------------------------------------------------------------
 * NAME : PostEventLogResponseDto.java
 * DESC : 이벤트 로그 저장 후 반환 DTO
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
package com.nexus.pdsw.dto.response.eventLog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nexus.pdsw.common.ResponseCode;
import com.nexus.pdsw.common.ResponseMessage;
import com.nexus.pdsw.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class PostEventLogResponseDto extends ResponseDto {
  
  /*  
   *  이벤트 로그 저장 후 반환 DTO(생성자)
   *  
   */
  private PostEventLogResponseDto() {
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
  }

  /*  
   *  이벤트 로그 저장 후 반환 DTO(성공)
   *  
   */
  public static ResponseEntity<PostEventLogResponseDto> success() {
    PostEventLogResponseDto result = new PostEventLogResponseDto();
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
}
