package me.whale.data.dbms.domain.system.base;

import me.whale.common.enums.content.ResourceType;
import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class TbResources extends BaseEntity {
    private static final long serialVersionUID = 8214599536414695049L;
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;
    private String showLink;
    private String actualLocation;
}
