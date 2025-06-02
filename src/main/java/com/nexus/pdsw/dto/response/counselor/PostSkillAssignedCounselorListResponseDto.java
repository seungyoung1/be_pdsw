/*------------------------------------------------------------------------------
 * NAME : PostSkillAssignedCounselorListResponseDto.java
 * DESC : 스킬 할당상담사 정보 리스트 항목 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/02/20  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.response.counselor;

import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nexus.pdsw.common.ResponseCode;
import com.nexus.pdsw.common.ResponseMessage;
import com.nexus.pdsw.dto.object.SkillAssignedCounselorListItem;
import com.nexus.pdsw.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class PostSkillAssignedCounselorListResponseDto extends ResponseDto {
  
  private List<SkillAssignedCounselorListItem> skillAssignedCounselorList;

  /*  
   *  스킬 할당 상담사 리스트 가져오기(성공)
   *  
   *  @param RedisTemplate<String, Object> redisTemplate1             레디스 개체
   *  @param List<Map<String, Object>> mapSkillAssignedCounselorList 반환할 상담사 리스트
   */
  private PostSkillAssignedCounselorListResponseDto(
    RedisTemplate<String, Object> redisTemplate1,
    List<Map<String, Object>> mapSkillAssignedCounselorList
  ) {

    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    this.skillAssignedCounselorList = SkillAssignedCounselorListItem.getSkillAssignedCounselorList(redisTemplate1, mapSkillAssignedCounselorList);
  }

  /*  
   *  스킬 할당 상담사 리스트 가져오기(성공)
   *  
   *  @param RedisTemplate<String, Object> redisTemplate1             레디스 개체
   *  @param List<Map<String, Object>> mapSkillAssignedCounselorList  반환할 상담사 리스트
   *  @return ResponseEntity<PostSkillAssignedCounselorListResponseDto>
   */
  public static ResponseEntity<PostSkillAssignedCounselorListResponseDto> success(
    RedisTemplate<String, Object> redisTemplate1,
    List<Map<String, Object>> mapSkillAssignedCounselorList
  ) {

    PostSkillAssignedCounselorListResponseDto result = new PostSkillAssignedCounselorListResponseDto(redisTemplate1, mapSkillAssignedCounselorList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  /*  
   *  스킬 할당 상담사 리스트 가져오기(테넌트ID가 없을 경우)
   *  
   *  @return ResponseEntity<ResponseDto>
   */
  public static ResponseEntity<ResponseDto> notExistTenantId() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_TENANTID, ResponseMessage.NOT_EXISTED_TENANTID);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  /*  
   *  스킬 할당 상담사 리스트 가져오기(스킬ID가 존재하지 않을 경우)
   *  
   *  @return ResponseEntity<ResponseDto>
   */
  public static ResponseEntity<ResponseDto> notExistSkillId() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_SKILLID, ResponseMessage.NOT_EXISTED_SKILLID);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  /*  
   *  스킬 할당 상담사 리스트 가져오기(API 인증 세션키가 없을 경우)
   *  
   *  @return ResponseEntity<ResponseDto>
   */
  public static ResponseEntity<ResponseDto> notExistSessionKey() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_SESSIONKEY, ResponseMessage.NOT_EXISTED_SESSIONKEY);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
}
