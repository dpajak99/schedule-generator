package org.example.mappers;

import org.example.models.schedule.TimetableTemplateModel;
import org.example.infra.entity.TimetableTemplateEntity;
import org.example.infra.entity.TimetableTemplateType;
import org.springframework.stereotype.Component;

@Component
public class TimetableTemplateMapper {
    public TimetableTemplateModel mapToModel(TimetableTemplateEntity timetableTemplateEntity) {
        TimetableTemplateModel timetableTemplateModel = new TimetableTemplateModel();
        timetableTemplateModel.setId(timetableTemplateEntity.getId());
        timetableTemplateModel.setUploaderId(timetableTemplateEntity.getUploaderId());
        timetableTemplateModel.setType(TimetableTemplateType.valueOf(timetableTemplateEntity.getType()));
        return timetableTemplateModel;
    }

    public TimetableTemplateEntity mapToEntity(TimetableTemplateModel timetableTemplateModel) {
        TimetableTemplateEntity timetableTemplateEntity = new TimetableTemplateEntity();
        timetableTemplateEntity.setId(timetableTemplateModel.getId());
        timetableTemplateEntity.setUploaderId(timetableTemplateModel.getUploaderId());
        timetableTemplateEntity.setType(timetableTemplateModel.getType().name());
        return timetableTemplateEntity;
    }
}
