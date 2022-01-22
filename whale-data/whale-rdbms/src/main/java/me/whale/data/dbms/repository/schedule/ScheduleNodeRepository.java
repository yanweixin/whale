package me.whale.data.dbms.repository.schedule;

import me.whale.common.enums.general.YesOrNo;
import me.whale.data.dbms.domain.schedule.ScheduleNode;
import me.whale.data.dbms.projection.ScheduleNodeBase;
import me.whale.data.dbms.repository.CustomRepository;

import java.util.List;

public interface ScheduleNodeRepository extends CustomRepository<ScheduleNode, Long> {
    /**
     * find all schedule nodes by version and whether is valid
     *
     * @param version
     * @param validOrNot
     * @return
     */
    List<ScheduleNode> findAllByVersionAndValid(Integer version, YesOrNo validOrNot);

    Integer findLatestVersionByBizType(String bizType);

    //TODO: adjust to spring jpa 3.0
//    ScheduleNodeBase findFirstByBizTypeAndVersionAndPreviousNode(String bizType, Integer version, Long previousNode);
}
