package fr.cactuscata.primenumber;

import java.util.List;

import fr.cactuscata.primenumber.file.FileRegisterer;
import fr.cactuscata.primenumber.script.Script;
import fr.cactuscata.primenumber.utils.ListUtils;

public final class Main {

	private static final List<Long> primeNumbers = FileRegisterer.init();

	public static final void main(final String[] args) {

		new Script().modWanted();

		ListUtils.range();

		FileRegisterer.updateFile(primeNumbers);

		System.exit(0);

	}

	public static final List<Long> getPrimeNumbers() {
		return Main.primeNumbers;
	}

}
