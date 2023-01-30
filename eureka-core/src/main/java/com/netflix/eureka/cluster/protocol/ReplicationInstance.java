package com.netflix.eureka.cluster.protocol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.eureka.registry.PeerAwareInstanceRegistryImpl.Action;
import javax.annotation.Nullable;

/**
 * The jersey resource class that generates a particular replication event
 */
public class ReplicationInstance {
    @Nullable private String appName;
    @Nullable private String id;
    @Nullable private Long lastDirtyTimestamp;
    @Nullable private String overriddenStatus;
    @Nullable private String status;
    @Nullable private InstanceInfo instanceInfo;
    @Nullable private Action action;

    @JsonCreator
    public ReplicationInstance(@Nullable @JsonProperty("appName") String appName,
                               @Nullable @JsonProperty("id") String id,
                               @Nullable @JsonProperty("lastDirtyTimestamp") Long lastDirtyTimestamp,
                               @Nullable @JsonProperty("overriddenStatus") String overriddenStatus,
                               @Nullable @JsonProperty("status") String status,
                               @Nullable @JsonProperty("instanceInfo") InstanceInfo instanceInfo,
                               @Nullable @JsonProperty("action") Action action) {
        this.appName = appName;
        this.id = id;
        this.lastDirtyTimestamp = lastDirtyTimestamp;
        this.overriddenStatus = overriddenStatus;
        this.status = status;
        this.instanceInfo = instanceInfo;
        this.action = action;
    }

    @Nullable public String getAppName() {
        return appName;
    }

    @Nullable public String getId() {
        return id;
    }

    @Nullable public Long getLastDirtyTimestamp() {
        return lastDirtyTimestamp;
    }

    @Nullable public String getOverriddenStatus() {
        return overriddenStatus;
    }

    @Nullable public String getStatus() {
        return status;
    }

    @Nullable public InstanceInfo getInstanceInfo() {
        return instanceInfo;
    }

    @Nullable public Action getAction() {
        return action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ReplicationInstance that = (ReplicationInstance) o;

        if (appName != null ? !appName.equals(that.appName) : that.appName != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (lastDirtyTimestamp != null ? !lastDirtyTimestamp.equals(that.lastDirtyTimestamp) : that.lastDirtyTimestamp != null)
            return false;
        if (overriddenStatus != null ? !overriddenStatus.equals(that.overriddenStatus) : that.overriddenStatus != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null)
            return false;
        if (instanceInfo != null ? !instanceInfo.equals(that.instanceInfo) : that.instanceInfo != null)
            return false;
        return action == that.action;

    }

    @Override
    public int hashCode() {
        int result = appName != null ? appName.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (lastDirtyTimestamp != null ? lastDirtyTimestamp.hashCode() : 0);
        result = 31 * result + (overriddenStatus != null ? overriddenStatus.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (instanceInfo != null ? instanceInfo.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

    public static ReplicationInstanceBuilder replicationInstance() {
        return ReplicationInstanceBuilder.aReplicationInstance();
    }

    public static class ReplicationInstanceBuilder {
        @Nullable private String appName;
        @Nullable private String id;
        @Nullable private Long lastDirtyTimestamp;
        @Nullable private String overriddenStatus;
        @Nullable private String status;
        @Nullable private InstanceInfo instanceInfo;
        @Nullable private Action action;

        private ReplicationInstanceBuilder() {
        }

        public static ReplicationInstanceBuilder aReplicationInstance() {
            return new ReplicationInstanceBuilder();
        }

        public ReplicationInstanceBuilder withAppName(@Nullable String appName) {
            this.appName = appName;
            return this;
        }

        public ReplicationInstanceBuilder withId(@Nullable String id) {
            this.id = id;
            return this;
        }

        public ReplicationInstanceBuilder withLastDirtyTimestamp(@Nullable Long lastDirtyTimestamp) {
            this.lastDirtyTimestamp = lastDirtyTimestamp;
            return this;
        }

        public ReplicationInstanceBuilder withOverriddenStatus(@Nullable String overriddenStatus) {
            this.overriddenStatus = overriddenStatus;
            return this;
        }

        public ReplicationInstanceBuilder withStatus(@Nullable String status) {
            this.status = status;
            return this;
        }

        public ReplicationInstanceBuilder withInstanceInfo(@Nullable InstanceInfo instanceInfo) {
            this.instanceInfo = instanceInfo;
            return this;
        }

        public ReplicationInstanceBuilder withAction(@Nullable Action action) {
            this.action = action;
            return this;
        }

        public ReplicationInstanceBuilder but() {
            return aReplicationInstance().withAppName(appName).withId(id).withLastDirtyTimestamp(lastDirtyTimestamp).withOverriddenStatus(overriddenStatus).withStatus(status).withInstanceInfo(instanceInfo).withAction(action);
        }

        public ReplicationInstance build() {
            return new ReplicationInstance(
                    appName,
                    id,
                    lastDirtyTimestamp,
                    overriddenStatus,
                    status,
                    instanceInfo,
                    action
            );
        }
    }
}
