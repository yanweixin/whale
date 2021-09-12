package me.whale.common.enums.system;

public enum TaskStatus {
    /**
     * initial state
     */
    NEW,
    /**
     * under executing
     */
    PENDING,
    /**
     * wait to be scheduled, maybe too busy to schedule or wait for outside resource
     * need to be recalled by system
     */
    WAITING,
    /**
     * is paused manually or caused by specific execution policy
     * need to be recalled manually
     */
    PAUSED,
    /**
     * task completed successfully
     */
    COMPLETED,
    /**
     * task failed and cannot recover
     */
    FAILED,
    /**
     * task is skipped
     */
    SKIPPED,
    ;
}
