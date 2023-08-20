package com.netflix.eureka.cluster;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.eureka.registry.PeerAwareInstanceRegistryImpl.Action;
import javax.annotation.Nullable;


/**
 * Base {@link ReplicationTask} class for instance related replication requests.
 *
 * @author Tomasz Bak
 */
public abstract class InstanceReplicationTask extends ReplicationTask {

    /**
     * For cancel request there may be no InstanceInfo object available so we need to store app/id pair
     * explicitly.
     */
    private final String appName;
    @Nullable private final String id;

    @Nullable private final InstanceInfo instanceInfo;
    @Nullable private final InstanceStatus overriddenStatus;

    private final boolean replicateInstanceInfo;

     protected InstanceReplicationTask(String peerNodeName, Action action, String appName, @Nullable String id) {
        super(peerNodeName, action);
        this.appName = appName;
        this.id = id;
        this.instanceInfo = null;
        this.overriddenStatus = null;
        this.replicateInstanceInfo = false;
    }

    protected InstanceReplicationTask(String peerNodeName,
                                      Action action,
                                      @Nullable InstanceInfo instanceInfo,
                                      @Nullable InstanceStatus overriddenStatus,
                                      boolean replicateInstanceInfo) {
        super(peerNodeName, action);
        this.appName = instanceInfo.getAppName();
        this.id = instanceInfo.getId();
        this.instanceInfo = instanceInfo;
        this.overriddenStatus = overriddenStatus;
        this.replicateInstanceInfo = replicateInstanceInfo;
    }

    public String getTaskName() {
        return appName + '/' + id + ':' + action + '@' + peerNodeName;
    }

    public String getAppName() {
        return appName;
    }

    @Nullable public String getId() {
        return id;
    }

    @Nullable public InstanceInfo getInstanceInfo() {
        return instanceInfo;
    }

    @Nullable public InstanceStatus getOverriddenStatus() {
        return overriddenStatus;
    }

    public boolean shouldReplicateInstanceInfo() {
        return replicateInstanceInfo;
    }
}
