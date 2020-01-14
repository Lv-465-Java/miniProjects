package com.itacademy.softserve.dto;

import java.util.Date;
import java.util.Objects;

public class HistoryDto {
    private Long id;
    private String task;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryDto that = (HistoryDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(task, that.task)) return false;
        if (!Objects.equals(modifiedDate, that.modifiedDate)) return false;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    private Date modifiedDate;
    private String status;

    public HistoryDto() {
    }

    public HistoryDto(String task, Date modifiedDate, String status) {
        this.task = task;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public HistoryDto(Long id, String task, Date modifiedDate, String status) {
        this.id = id;
        this.task = task;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
