package com.example.temporalconsumer.temporal;

import com.example.temporalconsumer.models.ActivityPlanEventModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendEmailConfirmationActivityImpl implements SendEmailConfirmationActivity{
  @Override
  public ActivityPlanEventModel emailSend(ActivityPlanEventModel activityPlan) {
  log.info("receieved activityPlan for booking id " + activityPlan.getBookingId());
   activityPlan.setEventName("Email Booking Confirmation Status");
    activityPlan.setStatus("SUCCESS");
      log.info("status " + activityPlan.getStatus());
   return activityPlan;
  }
}
