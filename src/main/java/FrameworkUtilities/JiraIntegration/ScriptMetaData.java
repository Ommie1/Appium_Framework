package FrameworkUtilities.JiraIntegration;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ScriptMetaData {

    boolean productionReady();
}
