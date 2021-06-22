package com.arsuarez.com.components;


import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class MessagesGestorUtil implements MessageSourceAware {

	private MessageSource messageSource;


	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String getMessage(String key, Object... parameters){

		return messageSource.getMessage(key, parameters, LocaleContextHolder.getLocale());

	}

	public String getMessage(String key){

		return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());

	}

	public String addArgumentsToMenssage(String mensaje, Object... args) {

		mensaje = MessageFormat.format(mensaje, args);
		return mensaje;
	}

}