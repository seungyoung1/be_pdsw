/*------------------------------------------------------------------------------
 * NAME : EnvironmentSettingPk.java
 * DESC : 환경설정 PK
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
package com.nexus.pdsw.entity.primaryKey;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentSettingPk {
  
    @Column(name = "CENTER_ID")
    private int centerId;          //센터ID
    @Column(name = "TENANT_ID")
    private int tenantId;          //테넌트ID
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;     //상담원ID
}
