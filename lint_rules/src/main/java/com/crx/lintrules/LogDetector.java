package com.crx.lintrules;

import com.android.tools.lint.client.api.UElementHandler;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.GradleContext;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.TextFormat;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiMethodCallExpression;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.uast.UAnnotation;
import org.jetbrains.uast.UCallExpression;
import org.jetbrains.uast.UCallableReferenceExpression;
import org.jetbrains.uast.UElement;
import org.jetbrains.uast.UField;
import org.jetbrains.uast.ULiteralExpression;
import org.jetbrains.uast.UMethod;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Detect the use of android.util.Log
 */
@SuppressWarnings("UnstableApiUsage")
public final class LogDetector extends Detector implements Detector.UastScanner{
    @Override
    public List<Class<? extends UElement>> getApplicableUastTypes() {
        return Collections.singletonList(UCallExpression.class);
    }

    @Override
    public UElementHandler createUastHandler(@NotNull JavaContext context) {
        return new UElementHandler(){
            @Override
            public void visitCallExpression(@NotNull UCallExpression node) {
                if(context.getEvaluator().isMemberInClass(node.resolve(), "android.util.Log")){
                    context.report(CustomIssues.LOG_ISSUE,
                            context.getLocation(node),
                            CustomIssues.LOG_ISSUE.getExplanation(TextFormat.TEXT));
                }

            }
        };
    }

}
