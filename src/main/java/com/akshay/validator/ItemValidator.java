package com.akshay.validator;

import com.akshay.exception.ItemNotFoundException;
import com.akshay.model.Item;

public class ItemValidator {
	public void validateSave(Item item) throws ItemNotFoundException {

		if ("".equals(item.getItemName()) || "".equals(item.getId()) || "".equals(item.getCategoryCode())
				|| "".equals(item.getItemClosingStock()) || "".equals(item.getItemOpeningStock())
				|| "".equals(item.getItemStockOnHand())) {

			throw new ItemNotFoundException("Please fill all fields.");

		}

	}

	public void validateUpdate(Item item) throws ItemNotFoundException {

		if (item.getItemOpeningStock() < 0 || item.getItemStockOnHand() < 0 || item.getItemClosingStock() < 0
				|| item.getId() < 0) {

			throw new ItemNotFoundException("Please dont fill negative values");

		}

	}

}
