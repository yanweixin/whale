package me.whale.data.dbms.domain.system.schedule;

import me.whale.common.enums.general.YesOrNo;
import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.Entity;

/**
 * @author weixin
 */
@Entity
public class NodeAction extends BaseEntity {
    private static final long serialVersionUID = 2790169015325022952L;
    /**
     * relate to ScheduleNode#id
     */
    private Long nodeId;

    private String action;

    private YesOrNo valid;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public YesOrNo getValid() {
        return valid;
    }

    public void setValid(YesOrNo valid) {
        this.valid = valid;
    }
}
