package fr.cactuscata.primenumber.utils;

import java.util.ArrayList;
import java.util.List;

import fr.cactuscata.primenumber.Main;

public final class ListUtils {

	public static final void range() {

		final List<Long> newList = new ArrayList<>();
		List<Long> oldList = Main.getPrimeNumbers();

		for (int i = 0, j = oldList.size(); i < j; i++)
			newList.add(0L);

		for (int i = 0, j = oldList.size(); i < j; i++) {
			int value = 0;

			for (final Long longNumber : oldList)
				if (oldList.get(i) > longNumber)
					value++;

			newList.set(value, oldList.get(i));

		}

		oldList = newList;

	}

}
