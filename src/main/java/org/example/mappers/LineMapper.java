package org.example.mappers;

import org.example.infra.entity.LineEntity;
import org.example.models.schedule.LineModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LineMapper {
    final TimetableVersionMapper timetableVersionMapper;

    @Autowired
    public LineMapper(TimetableVersionMapper timetableVersionMapper) {
        this.timetableVersionMapper = timetableVersionMapper;
    }

    LineModel mapToModel(LineEntity lineEntity) {
        LineModel lineModel = new LineModel();
        lineModel.setId(lineEntity.getId());
        lineModel.setTimetableVersion(timetableVersionMapper.mapToModel(lineEntity.getTimetableVersion()));
        lineModel.setName(lineEntity.getName());
        lineModel.setComments(lineEntity.getComments());
        return lineModel;
    }
    
    LineEntity mapToEntity(LineModel lineModel) {
        LineEntity lineEntity = new LineEntity();
        lineEntity.setId(lineModel.getId());
        lineEntity.setTimetableVersion(timetableVersionMapper.mapToEntity(lineModel.getTimetableVersion()));
        lineEntity.setName(lineModel.getName());
        lineEntity.setComments(lineModel.getComments());
        return lineEntity;
    }
}
