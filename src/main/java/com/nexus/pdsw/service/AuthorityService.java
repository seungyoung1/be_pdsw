/*------------------------------------------------------------------------------
 * NAME : AuthorityService.java
 * DESC : 권한
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/03/18  최상원                       초기작성
 * 2025/03/19  최상원                       사용자별 환경설정 가져오기 추가
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.service;

import org.springframework.http.ResponseEntity;

import com.nexus.pdsw.dto.request.PostEnvironmentSettingRequestDto;
import com.nexus.pdsw.dto.request.PostEnvironmentSettingSaveRequestDto;
import com.nexus.pdsw.dto.response.authority.GetAvailableMenuListResponseDto;
import com.nexus.pdsw.dto.response.authority.GetCenterInfoListResponseDto;
import com.nexus.pdsw.dto.response.authority.GetEnvironmentSettingResponseDto;
import com.nexus.pdsw.dto.response.authority.PostEnvironmentSettingSaveResponseDto;

public interface AuthorityService {
  
  /*
   *  사용가능한 메뉴 리스트 가져오기
   *
   *  @param int roleId    역할ID(1: 시스템관리자, 2: 테넌트관리자01, 3: 테넌트관리자02)
   *  @return ResponseEntity<? super GetAvailableMenuListResponseDto>
   */
  public ResponseEntity<?super GetAvailableMenuListResponseDto> getAvailableMenuList(int roleId);

  /*
   *  센터정보 가져오기
   *
   *  @return ResponseEntity<? super GetCenterInfoListResponseDto>
   */
  public ResponseEntity<? super GetCenterInfoListResponseDto> getCenterInfo();

  /*
   *  사용자별 환경설정 가져오기
   *
   *  @param PostEnvironmentSettingRequestDto requestDto    전달 DTO
   *  @return ResponseEntity<? super GetEnvironmentSettingResponseDto>
   */
  public ResponseEntity<? super GetEnvironmentSettingResponseDto> getEnvironmentSetting(PostEnvironmentSettingRequestDto requestDto);

  /*
   *  사용자별 환경설정 저장하기
   *
   *  @param PostEnvironmentSettingSaveRequestDto requestDto    전달 DTO
   *  @return ResponseEntity<? super PostEnvironmentSettingSaveResponseDto>
   */
  public ResponseEntity<? super PostEnvironmentSettingSaveResponseDto> postEnvironmentSetting(PostEnvironmentSettingSaveRequestDto requestDto);
}
