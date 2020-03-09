package com.example.securingweb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public class Access {

	@Target({ ElementType.TYPE, ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	@PreAuthorize("hasRole('INTERNAL')")
	public @interface HasInternalAccess {

		@Target({ ElementType.TYPE, ElementType.METHOD })
		@Retention(RetentionPolicy.RUNTIME)
		@PreAuthorize("hasAnyRole('ADMIN', 'INTERNAL')")
		public @interface AndAdmin {

		}

	}

	@Target({ ElementType.TYPE, ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	@PreAuthorize("hasRole('CUSTOMER')")
	public @interface HasCustomerAccess {

	}
}
