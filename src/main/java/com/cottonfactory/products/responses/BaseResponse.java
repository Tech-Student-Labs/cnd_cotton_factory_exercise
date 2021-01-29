package com.cottonfactory.products.responses;

import java.util.ArrayList;
import java.util.List;

/**
 * The BaseResponse holds wrapper around errors and can be extended to incorporate errors in api response
 */
public class BaseResponse {
	private List<ProductError> errors = new ArrayList<>();

	public List<ProductError> getErrors() {
		return errors;
	}

	/**
	 * Adds the product error.
	 * Convenience method to append errors to existing list of errors in base response
	 *
	 * @param error the error
	 */	
	public void addProductError(ProductError error) {
		if(null == this.errors) {
			this.errors = new ArrayList<>();
		}
		this.errors.add(error);
	}
}
