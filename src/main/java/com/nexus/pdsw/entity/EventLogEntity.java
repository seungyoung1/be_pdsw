/*------------------------------------------------------------------------------
 * NAME : EventLogEntity.java
 * DESC : 로그기록 엔티티
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
package com.nexus.pdsw.entity;

import java.time.LocalDateTime;

import com.nexus.pdsw.common.AesEncDecConverter;
import com.nexus.pdsw.dto.request.PostEventLogRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="event_log")
public class EventLogEntity {
  
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "uidx", nullable = false)
  private Long uidx;                //일련번호
  @Column(name = "tenant_id", nullable = false)
  private int tenantId;             //테넌트ID
  @Column(name = "employee_id", nullable = false)
  private String employeeId;        //상담원ID
  @Column(name = "user_host", nullable = false)
  private String userHost;          //접속ip, hostname등
  @Column(name = "query_id", nullable = false)
  private String queryId;           //web query id
  @Column(name = "query_type", nullable = false)
  private String queryType;         //이벤트타입 I:insert, U:update, D:delete, R:select, A:자원변경
  @Column(name = "activation", nullable = false)
  private String activation;        //행위 로그
  @Convert(converter = AesEncDecConverter.class)
  @Column(name = "description", nullable = true)
  private String description;       //부가정보
  @Column(name = "success_flag", nullable = true)
  private int successFlag;          //성공여부 1 : 성공 0 : 실패 또는 DB 에러코드
  @Column(name = "event_time", nullable = false)
  private LocalDateTime eventTime;  //이벤트일시
  @Column(name = "event_name", nullable = true)
  private String eventName;         //이벤트명 login, logout, 테이블명, employee.postion_level
  @Column(name = "query_rows", nullable = false)
  private int queryRows;            //조회건수
  @Column(name = "target_id", nullable = true)
  private String targetId;          //대상자ID
  @Column(name = "user_session_type", nullable = true)
  private int userSessionType;      //사용자접속타입 0 : 로컬PC 1 : VDI 또는 재택 연결 시
  @Column(name = "export_flag", nullable = true)
  private int exportFlag;           //export실행여부 1 : export 실행
  @Column(name = "memo", nullable = true)
  private String memo;              //메모 ex)파일다운사유 등
  @Column(name = "update_employee_id", nullable = true)
  private String updateEmployeeId;  //수정상담원ID
  @Column(name = "update_time", nullable = true)
  private LocalDateTime updateTime; //수정일시

	/*
   * 생성자
   * @param PostEventLogRequestDto dto    이벤트로그 개체
   * @param String clientIp               클라이언트IP
	 * 
	*/
  public EventLogEntity(PostEventLogRequestDto dto, String clientIp) {

    this.tenantId = dto.getTenantId();
    this.employeeId = dto.getEmployeeId();
    this.userHost = clientIp;
    this.queryId = dto.getQueryId();
    this.queryType = dto.getQueryType();
    this.activation = dto.getActivation();
    this.description = dto.getDescription();
    this.successFlag = dto.getSuccessFlag();
    this.eventTime = LocalDateTime.now();
    this.eventName = dto.getEventName();
    this.queryRows = dto.getQueryRows();
    this.targetId = dto.getTargetId();
    this.userSessionType = dto.getUserSessionType();
    this.exportFlag = dto.getExportFlag();
    this.memo = dto.getMemo();
    this.updateEmployeeId = dto.getUpdateEmployeeId();
    this.updateTime = LocalDateTime.now();
  }
}
