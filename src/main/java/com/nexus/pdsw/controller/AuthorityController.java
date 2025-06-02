/*------------------------------------------------------------------------------
 * NAME : AuthorityController.java
 * DESC : 권한관리리
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
package com.nexus.pdsw.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexus.pdsw.dto.request.PostEnvironmentSettingRequestDto;
import com.nexus.pdsw.dto.request.PostEnvironmentSettingSaveRequestDto;
import com.nexus.pdsw.dto.response.authority.GetAvailableMenuListResponseDto;
import com.nexus.pdsw.dto.response.authority.GetCenterInfoListResponseDto;
import com.nexus.pdsw.dto.response.authority.GetEnvironmentSettingResponseDto;
import com.nexus.pdsw.dto.response.authority.PostEnvironmentSettingSaveResponseDto;
import com.nexus.pdsw.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api_upds/v1/auth")
@RequiredArgsConstructor
public class AuthorityController {

  private final AuthorityService authorityService;

  /*
   *  사용가능한 메뉴 리스트 가져오기
   *
   *  @param int roleId    역할ID(1: 시스템관리자, 2: 테넌트관리자01, 3: 테넌트관리자02)
   *  @return ResponseEntity<? super GetAvailableMenuListResponseDto>
   */
  @GetMapping("/availableMenuList")
  public ResponseEntity<?super GetAvailableMenuListResponseDto> getAvailableMenuList(
    @RequestParam(required = true, value = "roleId") int roleId
  ) {
    ResponseEntity<?super GetAvailableMenuListResponseDto> response = authorityService.getAvailableMenuList(roleId);
    return response;
  }

  /*
   *  센터정보 가져오기
   *
   *  @return ResponseEntity<? super GetCenterInfoListResponseDto>
   */
  @GetMapping("/centerInfo")
  public ResponseEntity<?super GetCenterInfoListResponseDto> getCenterInfo() {
    ResponseEntity<?super GetCenterInfoListResponseDto> response = authorityService.getCenterInfo();
    return response;
  }

  /*
   *  사용자별 환경설정 가져오기
   *
   *  @param PostEnvironmentSettingRequestDto requestDto    전달 DTO
   *  @return ResponseEntity<? super GetEnvironmentSettingResponseDto>
   */
  @PostMapping("/environment")
  public ResponseEntity<? super GetEnvironmentSettingResponseDto> getEnvironmentSetting(
    @RequestBody PostEnvironmentSettingRequestDto requestDto
  ) {
    ResponseEntity<? super GetEnvironmentSettingResponseDto> response = authorityService.getEnvironmentSetting(requestDto);
    return response;
  }

  /*
   *  사용자별 환경설정 저장하기
   *
   *  @param PostEnvironmentSettingSaveRequestDto requestDto    전달 DTO
   *  @return ResponseEntity<? super PostEnvironmentSettingSaveResponseDto>
   */
  @PostMapping("/environment/save")
  public ResponseEntity<? super PostEnvironmentSettingSaveResponseDto> postEnvironmentSetting(
    @RequestBody PostEnvironmentSettingSaveRequestDto requestDto
  ) {
    ResponseEntity<? super PostEnvironmentSettingSaveResponseDto> response = authorityService.postEnvironmentSetting(requestDto);
    return response;
  }
}
