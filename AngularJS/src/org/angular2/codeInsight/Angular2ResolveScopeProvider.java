package org.angular2.codeInsight;

import com.intellij.lang.javascript.DialectDetector;
import com.intellij.lang.javascript.psi.ecmal4.JSClass;
import com.intellij.lang.javascript.psi.resolve.JSElementResolveScopeProvider;
import com.intellij.lang.javascript.psi.resolve.JSResolveUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.angular2.index.Angular2IndexingHandler;
import org.angular2.lang.expr.Angular2Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Dennis.Ushakov
 */
public class Angular2ResolveScopeProvider implements JSElementResolveScopeProvider {

  @Nullable
  @Override
  public GlobalSearchScope getElementResolveScope(@NotNull PsiElement element) {
    if (Angular2Language.INSTANCE.is(DialectDetector.languageDialectOfElement(element))) {
      JSClass clazz = Angular2IndexingHandler.findComponentClass(element);
      if (clazz != null) {
        return JSResolveUtil.getResolveScope(clazz);
      }
    }
    return null;
  }
}
