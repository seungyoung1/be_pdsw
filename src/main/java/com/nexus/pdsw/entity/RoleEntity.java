/*------------------------------------------------------------------------------
 * NAME : RoleEntity.java
 * DESC : 역할 엔티티
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
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="T_ROLE_LIST")
public class RoleEntity {
  
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "ROLE_ID")
  private Integer roleId;           //역할ID
  @Column(name = "ROLE_NAME")
  private String roleName;          //역할명
  @Column(name = "USE_YN")
  private String useYn;             //사용여부
  @Column(name = "NOTE")
  private String note;              //비고
  @Column(name = "CREATE_ID")
  private String createId;          //생성자ID
  @Column(name = "CREATE_TIME")
  private LocalDateTime createTime; //생성일시
  @Column(name = "CREATE_IP")
  private String createIp;          //생성자IP
  @Column(name = "UPDATE_ID")
  private String updateId;          //수정자ID
  @Column(name = "UPDATE_TIME")
  private LocalDateTime updateTime; //수정일시
  @Column(name = "UPDATE_IP")
  private String updateIp;          //수정자IP

  @OneToMany(mappedBy = "role", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
  private List<MenuByRoleEntity> menuList = new ArrayList<>();        //역할과 연결된 메뉴 개체 리스트

}
