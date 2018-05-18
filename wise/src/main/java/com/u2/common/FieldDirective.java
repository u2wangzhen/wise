package com.u2.common;

import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.CharTable;
import com.jfinal.template.stat.Scope;

public class FieldDirective extends Directive{


	@Override
	public void exec(Env env, Scope scope, Writer writer) {
		String key = exprList.eval(scope).toString().trim();
        write(writer, key);
        if (CharTable.isLetterOrDigit(key.charAt(key.length() - 1))) {
            write(writer, " like ");
        }
	}

}