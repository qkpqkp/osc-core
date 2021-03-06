/*******************************************************************************
 * Copyright (c) Intel Corporation
 * Copyright (c) 2017
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.osc.core.broker.service.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osc.core.broker.service.dto.job.LockObjectDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
        description = "Parent Id is applicable for this object. The corresponding Job is considered the parent of this Task.")
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskRecordDto extends BaseDto {

    private Long dependencyOrder;
    private String name;
    private String state;
    private String status;
    private Date queued;
    private Date started;
    private Date completed;
    @ApiModelProperty(value="A comma seperated list of predecessor Task IDs for this Task")
    private String predecessors;
    private String failReason;

    @ApiModelProperty(value = "List of object references relevant to this job. For example, in a Distributed Appliance "
            + "Synchronization Job, the Distributed Appliance Object reference will be included ")
    private Set<LockObjectDto> objects;

    /**
     * These fields are being made transient so as not to affect external
     * clients of the REST Services by adding more data. The data is
     * needed, however, by clients of the OSC services.
     */
    @XmlTransient
    private List<TaskRecordDto> children;

    @XmlTransient
    private String taskGuard;

    @XmlTransient
    private List<Long> predecessorIds;

    @Override
    public String toString() {
        return "TaskRecordDto [id=" + getId() + ", dependencyOrder=" + this.dependencyOrder + ", jobId=" + getParentId() + ", name="
                + this.name + ", state=" + this.state + ", status=" + this.status + ", queued=" + this.queued + ", started=" + this.started
                + ", completed=" + this.completed + ", failReason=" + this.failReason + "]";
    }

    public String getFailReason() {
        return this.failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public Long getDependencyOrder() {
        return this.dependencyOrder;
    }

    public void setDependencyOrder(Long dependency) {
        this.dependencyOrder = dependency;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getQueued() {
        return this.queued;
    }

    public void setQueued(Date queued) {
        this.queued = queued;
    }

    public Date getStarted() {
        return this.started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getCompleted() {
        return this.completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public String getPredecessors() {
        return this.predecessors;
    }

    public void setPredecessors(String predecessors) {
        this.predecessors = predecessors;
    }

    public Set<LockObjectDto> getObjects() {
        return this.objects;
    }

    public void setObjects(Set<LockObjectDto> objects) {
        this.objects = objects;
    }

    public List<TaskRecordDto> getChildren() {
        return this.children;
    }

    public void setChildren(List<TaskRecordDto> children) {
        this.children = children;
    }

    public String getTaskGuard() {
        return this.taskGuard;
    }

    public void setTaskGuard(String taskGuard) {
        this.taskGuard = taskGuard;
    }

    public List<Long> getPredecessorIds() {
        return this.predecessorIds;
    }

    public void setPredecessorIds(List<Long> predecessorIds) {
        this.predecessorIds = predecessorIds;
    }
}
