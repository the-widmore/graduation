package com.ccniit.graduation.validator;

import org.springframework.context.annotation.Scope;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import com.ccniit.graduation.exception.IException;
import com.ccniit.graduation.exception.PropertyCanNotBeNullException;
import com.ccniit.graduation.resource.SpringScope;

@Component("objectFieldNullChecher")
@Scope(value = SpringScope.PROTOTYPE)
public class ObjectFieldNullChecher implements BaseChecker<Object, String> {

	protected SpelExpressionParser parser = new SpelExpressionParser();
	protected StandardEvaluationContext context = new StandardEvaluationContext();

	/**
	 * 
	 * */
	@Override
	public boolean check(Object source, String checker) throws IException {
		context.setVariable("source", source);
		Expression expression = parser.parseExpression("#source.".concat(checker));
		Object object = expression.getValue(context);
		if (null != object) {
			return false;
		} else {
			throw new PropertyCanNotBeNullException(source.getClass().getName() + "." + checker + " can not be null!");
		}

	}

}
