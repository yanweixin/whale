package me.whale.data.dbms.domain.schedule;

import me.whale.common.enums.general.YesOrNo;
import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author weixin
 */
@Entity
public class ScheduleNode extends BaseEntity {
    private static final long serialVersionUID = 5628389892326177680L;
    @NotEmpty
    private String bizType;
    /**
     * node code
     */
    private String node;
    /**
     * node description
     */
    private String description;
    private Long previousNode;
    private Long nextNode;
    @NotNull
    private Integer version;
    @NotNull
    private YesOrNo valid;

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Long previousNode) {
        this.previousNode = previousNode;
    }

    public Long getNextNode() {
        return nextNode;
    }

    public void setNextNode(Long nextNode) {
        this.nextNode = nextNode;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public YesOrNo getValid() {
        return valid;
    }

    public void setValid(YesOrNo valid) {
        this.valid = valid;
    }
}
