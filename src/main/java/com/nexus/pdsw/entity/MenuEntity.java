/*------------------------------------------------------------------------------
 * NAME : MenuEntity.java
 * DESC : 메뉴 엔티티
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/03/18  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
@Table(name="T_MENU_LIST")
public class MenuEntity {
  
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "MENU_ID")
  private Integer menuId;                 //메뉴ID
  @Column(name = "MENU_NAME")
  private String menuName;                //메뉴명
  @Column(name = "LOCATION_DISTINCTION_CODE")
  private String locationDistinctionCode; //위치구분코드
/*
    [위치구분코드]
    TOP: TOP 메뉴
    SCC: 사이드바(캠페인) 센터 컨텍스트 메뉴
    SCT: 사이드바(캠페인) 테넌트 컨텍스트 메뉴
    SCM: 사이드바(캠페인) 켐페인 컨텍스트 메뉴
    SSG: 사이드바(상담원) 그룹 컨텍스트 메뉴
    SST: 사이드바(상담원) 팀 컨텍스트 메뉴
    SSS: 사이드바(상담원) 상담원 컨텍스트 메뉴
    SGT: 사이드바(켐페인 그룹) 테넌트 컨텍스트 메뉴
    SGG: 사이드바(켐페인 그룹) 캠페인 그룹 컨텍스트 메뉴
    SGC: 사이드바(켐페인 그룹) 캠페인 컨텍스트 메뉴
*/
  @Column(name = "UPPER_MENU_ID")
  private Integer upperMenuId;            //상위메뉴ID
  @Column(name = "CONNECTION_TYPE")
  private String connectionType;          //연결유형(S:화면, M:메뉴, A:동작)
  @Column(name = "CONNECTION_SCREEN_ID")
  private String connectionScreenId;      //연결화면ID
  @Column(name = "USE_YN")
  private String useYn;                   //사용여부
  @Column(name = "CREATE_ID")
  private String createId;                //생성자ID
  @Column(name = "CREATE_TIME")
  private LocalDateTime createTime;       //생성일시
  @Column(name = "CREATE_IP")
  private String createIp;                //생성자IP
  @Column(name = "UPDATE_ID")
  private String updateId;                //수정자ID
  @Column(name = "UPDATE_TIME")
  private LocalDateTime updateTime;       //수정일시
  @Column(name = "UPDATE_IP")
  private String updateIp;                //수정자IP
}
