package com.example.temporalconsumer.temporal;

import com.example.temporalconsumer.models.ActivityPlanEventModel;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface SendEmailConfirmationActivity {
  @ActivityMethod(name = "sendEmail")
  ActivityPlanEventModel emailSend(ActivityPlanEventModel activityPlan);
}

