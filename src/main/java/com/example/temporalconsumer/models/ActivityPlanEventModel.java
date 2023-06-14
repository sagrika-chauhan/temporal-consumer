package com.example.temporalconsumer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class for activityplan.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityPlanEventModel {

  String productName;
  String domainName;
  String orderId;
  String bookingId;
  String eventName;
  String userId;
  String userName;
  String activityDateTime;
  String status;
  String domainData;
}

