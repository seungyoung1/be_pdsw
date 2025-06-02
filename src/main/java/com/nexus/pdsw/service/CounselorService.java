/*------------------------------------------------------------------------------
 * NAME : CounselorService.java
 * DESC : 상담사 내역 불러오기
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/01/15  최상원                       초기작성
 * 2025/01/18  최상원                       상담사 상태정보 가져오기 추가
 * 2025/02/20  최상원                       스킬 할당된 상담사 리스트 가져오기 추가
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.service;

import org.springframework.http.ResponseEntity;

import com.nexus.pdsw.dto.request.PostCounselorListRequestDto;
import com.nexus.pdsw.dto.request.PostSkillAssignedCounselorListRequestDto;
import com.nexus.pdsw.dto.response.counselor.GetCounselorInfoListResponseDto;
import com.nexus.pdsw.dto.response.counselor.GetCounselorListResponseDto;
import com.nexus.pdsw.dto.response.counselor.PostCounselorStatusListResponseDto;
import com.nexus.pdsw.dto.response.counselor.PostSkillAssignedCounselorListResponseDto;

public interface CounselorService {
 
  /*  
   *  상담사 리스트 가져오기
   *  
   *  @param PostCounselorListRequestDto requestBody  상담사 리스트 전달 DTO
   *  @return ResponseEntity<? super GetCounselorListResponseDto>
   */
  ResponseEntity<? super GetCounselorListResponseDto> getCounselorList(PostCounselorListRequestDto requestBody);

  /*
   *  상담사 상태정보 가져오기
   *  
   *  @param PostCounselorListRequestDto requestBody    전달 DTO
   *  @return ResponseEntity<? super PostCounselorStatusListResponseDto>
   */
  ResponseEntity<? super PostCounselorStatusListResponseDto> getCounselorStatusList(PostCounselorListRequestDto requestBody);

  /*
   *  캠페인 할당 상담사정보 가져오기
   *  
   *  @param PostCounselorListRequestDto requestBody    전달 매개변수 개체 DTO
   *  @return ResponseEntity<? super GetCounselorInfoListResponseDto>
   */
  ResponseEntity<? super GetCounselorInfoListResponseDto> getCounselorInfoList(PostCounselorListRequestDto requestBody);

  /*
   *  스킬 할당 상담사 목록 가져오기
   *  
   *  @param PostSkillAssignedCounselorListRequestDto requestBody    전달 매개변수 개체 DTO
   *  @return ResponseEntity<? super PostSkillAssignedCounselorListResponseDto>
   */
  ResponseEntity<? super PostSkillAssignedCounselorListResponseDto> getSillAssignedCounselorList(PostSkillAssignedCounselorListRequestDto requestBody);
}
