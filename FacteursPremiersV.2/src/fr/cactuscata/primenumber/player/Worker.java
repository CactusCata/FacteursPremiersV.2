package fr.cactuscata.primenumber.player;

import java.util.ArrayList;
import java.util.List;

import fr.cactuscata.primenumber.Main;
import fr.cactuscata.primenumber.utils.Msg;

public final class Worker {

	private final List<Long> firstFactors = new ArrayList<>();
	private long basicNumber;

	public void getPrimeNumbers(final long number) {
		this.basicNumber = number;
		recursivity(number);
		Msg.sendBoxMessage("Les facteurs premiers du nombre %d sont: %s%n", this.basicNumber, this.firstFactors);

	}

	private final long recursivity(final long number) {

		final List<Long> primeNumbers = Main.getPrimeNumbers();

		if (primeNumbers.contains(number)) {
			this.firstFactors.add(number);
			return number;
		}

		long k = 0;

		for (final Long nombrePremier : primeNumbers) {
			if (number % nombrePremier == 0) {
				this.firstFactors.add(nombrePremier);
				k = nombrePremier;
				break;
			}
		}

		if (k == 0) {
			primeNumbers.add(number);
			Msg.sendBoxMessage("L'IA a appris un nouveau nombre premier : %d !%n", number);
			return recursivity(this.basicNumber);
		}

		return recursivity(number / k);

	}

}
