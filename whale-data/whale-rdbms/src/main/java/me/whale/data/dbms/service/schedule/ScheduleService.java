package me.whale.data.dbms.service.schedule;

import me.whale.data.dbms.domain.schedule.ScheduleNode;
import me.whale.data.dbms.projection.ScheduleNodeBase;
import me.whale.data.dbms.repository.schedule.NodeActionRepository;
import me.whale.data.dbms.repository.schedule.ScheduleNodeRepository;
import me.whale.data.dbms.repository.schedule.ScheduleTaskRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleTaskRepository scheduleTaskRepository;
    private final ScheduleNodeRepository scheduleNodeRepository;
    private final NodeActionRepository nodeActionRepository;

    public ScheduleService(ScheduleTaskRepository scheduleTaskRepository, ScheduleNodeRepository scheduleNodeRepository,
                           NodeActionRepository nodeActionRepository) {
        this.scheduleTaskRepository = scheduleTaskRepository;
        this.scheduleNodeRepository = scheduleNodeRepository;
        this.nodeActionRepository = nodeActionRepository;
    }

    public ScheduleNode insertScheduleNode(ScheduleNode record) {
        return scheduleNodeRepository.save(record);
    }

    public ScheduleNodeBase selectStartNode(String bizType) {
        Integer latestVersion = scheduleNodeRepository.findLatestVersionByBizType(bizType);
        if (latestVersion == null) {
            return null;
        }
        return scheduleNodeRepository.findFirstByBizTypeAndVersionAndPreviousNode(bizType, latestVersion, null);
    }
}
