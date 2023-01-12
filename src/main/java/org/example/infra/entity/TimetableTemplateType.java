package org.example.infra.entity;

public enum TimetableTemplateType {
    by_route {
        boolean isMultiple() {
            return true;
        }
    },
    by_stop {
        boolean isMultiple() {
            return false;
        }
    }
}
