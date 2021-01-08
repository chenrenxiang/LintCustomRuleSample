package com.crx.lintrules;

import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

@SuppressWarnings("UnstableApiUsage")
public final class CustomIssues {

    private static final Implementation javaFileImpl = new Implementation(LogDetector.class, Scope.JAVA_FILE_SCOPE);

    private static Issue createDefaultIssue(String id, String briefDesc, String explanation){
        /**
         *
         */
        Issue.create("Log_Issue",
                "Do not use Log",
                "Please Use `LogUtil` instead of `android.util.Log`",
                Category.CORRECTNESS,
                6,
                Severity.ERROR,
                new Implementation(LogDetector.class, Scope.JAVA_FILE_SCOPE));
        return Issue.create(id, briefDesc, explanation, Category.CORRECTNESS, 6, Severity.ERROR, javaFileImpl);
    }

    //Log Issue
    public final static Issue LOG_ISSUE = createDefaultIssue("Log_Issue",
            "Do not use Log",
            "Please Use `LogUtil` instead of `android.util.Log`");
}
