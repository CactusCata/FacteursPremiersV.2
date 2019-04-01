package fr.cactuscata.primenumber.player;

import java.util.ArrayList;
import java.util.List;

import fr.cactuscata.primenumber.Main;
import fr.cactuscata.primenumber.utils.Msg;
import fr.cactuscata.primenumber.utils.ProgressBar;

public final class Learner {

	private final long timeStart = System.currentTimeMillis();
	private long space = this.timeStart;
	private int cacheNumberLearned, totalNumberLearned;
	private final List<String> information = new ArrayList<>();

	public final void learn(final int second) {

		final ProgressBar bar = new ProgressBar(second * 10);
		bar.ini();
		long cacheTime = System.currentTimeMillis();

		for (long number = 4; System.currentTimeMillis() < this.timeStart + second * 1000; number++) {
			learn(number);
			final long current = System.currentTimeMillis();
			while (current > cacheTime) {
				cacheTime += 100;
				bar.add();
			}
		}

		bar.close();
		Msg.sendBoxMessage("%d nombres premiers appris en %d secondes.", this.totalNumberLearned, second);
	}

	public final void learn(long firstPart, final long secondPart) {

		if (firstPart < 4)
			firstPart = 4;

		final ProgressBar bar = new ProgressBar((int) firstPart, (int) secondPart);
		bar.ini();

		while (firstPart < secondPart) {
			learn(firstPart);
			firstPart++;
			bar.add();
		}

		bar.close();

		Msg.sendBoxMessage("%d nombres premiers appris en %d secondes.%n", this.totalNumberLearned,
				((System.currentTimeMillis() - this.timeStart) / 1000));
		Msg.sendBoxMessage(this.information.toString());
	}

	public final void learn() {
		learn(4L, Long.MAX_VALUE);
	}

	public final void learn(final long number) {

		final List<Long> primeNumbers = Main.getPrimeNumbers();

		if (primeNumbers.contains(number))
			return;

		long k = 0;

		for (final Long nombrePremier : primeNumbers) {
			if (number % nombrePremier == 0) {
				k = nombrePremier;
				break;
			}
		}

		if (k == 0) {
			primeNumbers.add(number);
			this.cacheNumberLearned++;
			this.totalNumberLearned++;
			if (System.currentTimeMillis() - 1000 > this.space) {
				if (this.information.size() < 31)
					this.information.add(String.format("L'IA a appris %d nombres premiers. (total: %d)%n",
							this.cacheNumberLearned, this.totalNumberLearned));

				this.space = System.currentTimeMillis();
				this.cacheNumberLearned = 0;
			}

			return;
		}

		learn(number / k);
	}

}
