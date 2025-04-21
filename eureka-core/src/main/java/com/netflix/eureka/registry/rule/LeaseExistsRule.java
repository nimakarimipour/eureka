package com.netflix.eureka.registry.rule;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.eureka.lease.Lease;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This rule matches if we have an existing lease for the instance that is UP or OUT_OF_SERVICE.
 *
 * <p>Created by Nikos Michalakis on 7/13/16.
 */
public class LeaseExistsRule implements InstanceStatusOverrideRule {

  private static final Logger logger = LoggerFactory.getLogger(LeaseExistsRule.class);

  @Override
  public StatusOverrideResult apply(
      InstanceInfo instanceInfo, Lease<InstanceInfo> existingLease, boolean isReplication) {
    if (!isReplication) {
      InstanceInfo.InstanceStatus existingStatus = null;
      if (existingLease != null) {
        existingStatus = existingLease.getHolder().getStatus();
      }
      if ((existingStatus != null)
          && (InstanceInfo.InstanceStatus.OUT_OF_SERVICE.equals(existingStatus)
              || InstanceInfo.InstanceStatus.UP.equals(existingStatus))) {
        String statusName = existingStatus.name();
        String instanceId = existingLease.getHolder().getId();
        logger.debug(
            "There is already an existing lease with status {}  for instance {}",
            statusName,
            instanceId);
        return StatusOverrideResult.matchingStatus(existingStatus);
      }
    }
    return StatusOverrideResult.NO_MATCH;
  }

  @Override
  public String toString() {
    return LeaseExistsRule.class.getName();
  }
}
