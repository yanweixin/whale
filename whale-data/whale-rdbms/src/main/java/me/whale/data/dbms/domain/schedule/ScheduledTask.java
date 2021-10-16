package me.whale.data.dbms.domain.schedule;

import me.whale.common.enums.system.TaskStatus;
import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author weixin
 */
@Entity
public class ScheduledTask extends BaseEntity {
    private static final long serialVersionUID = 958883240918231919L;
    private String bizType;
    private String bizNo;
    private String currentNode;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    private Integer taskCount;

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }
}
