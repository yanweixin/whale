package me.whale.data.dbms.projection;

import me.whale.common.enums.general.YesOrNo;

public interface ScheduleNodeBase {
    Long getId();

    String getBizType();

    String getNode();

    String getDescription();

    Long getPreviousNode();

    Long getNextNode();

    Integer getVersion();

    YesOrNo getValid();
}
