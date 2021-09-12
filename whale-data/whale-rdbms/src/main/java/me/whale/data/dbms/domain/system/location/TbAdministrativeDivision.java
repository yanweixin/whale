package me.whale.data.dbms.domain.system.location;

import me.whale.data.dbms.domain.IdEntity;

public class TbAdministrativeDivision extends IdEntity {
    private static final long serialVersionUID = -2301615521710152786L;
    private int level;
    private String name;
    private String code;
    private Long parentId;
}
