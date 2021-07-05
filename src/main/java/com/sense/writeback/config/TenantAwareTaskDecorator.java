package com.sense.writeback.config;

import com.sense.writeback.interceptor.TenantContext;
import org.springframework.core.task.TaskDecorator;
import org.springframework.lang.NonNull;

import static com.sense.writeback.config.Constant.DEFAULT_TENANT;

public class TenantAwareTaskDecorator implements TaskDecorator {

    @Override
    @NonNull
    public Runnable decorate(@NonNull Runnable runnable) {
        String tenantId = TenantContext.getCurrentTenant();
        return () -> {
            try {
                TenantContext.setCurrentTenant(tenantId);
                runnable.run();
            } finally {
                TenantContext.setCurrentTenant(DEFAULT_TENANT);
            }
        };
    }
}