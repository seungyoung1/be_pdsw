/*------------------------------------------------------------------------------
 * NAME : PostEnvironmentSettingSaveResponseDto.java
 * DESC : 환경설정 저장 후 반환 항목 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/03/19  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.response.authority;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nexus.pdsw.common.ResponseCode;
import com.nexus.pdsw.common.ResponseMessage;
import com.nexus.pdsw.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class PostEnvironmentSettingSaveResponseDto extends ResponseDto {
  
  /*  
   *  환경설정 가져오기(생성자)
   *  
   *  @param List<MenuByRoleEntity> menuListByRole  반환할 메뉴 리스트
   */
  private PostEnvironmentSettingSaveResponseDto() {
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
  }

  /*  
   *  환경설정 가져오기(성공)
   *  
   *  @return ResponseEntity<GetEnvironmentSettingResponseDto>
   */
  public static ResponseEntity<PostEnvironmentSettingSaveResponseDto> success() {

    PostEnvironmentSettingSaveResponseDto result = new PostEnvironmentSettingSaveResponseDto();
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
}
